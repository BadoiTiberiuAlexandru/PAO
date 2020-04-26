import java.util.Scanner;

public class Start {
    public static void main(String[] args) {
        ClientDatabase cdb = new ClientDatabase("ClientDB.csv");
        ProductDatabase pdb = new ProductDatabase("ProductDB.csv");
        PaymentMethod pay = new PaymentMethod();
        Audit aud = new Audit ("Audit.csv");
        Scanner s = new Scanner(System.in);
        int button;
        boolean exit1 = false;
        boolean exit2 = false;
        System.out.println("Please select a mode for this register to be used in:");
        System.out.println("1: Cashier mode");
        System.out.println("2: Administrative mode");
        System.out.println("0: Shut Down");
        button = s.nextInt();
        if (button == 0) return;
        while (button != 1 && button != 2) {
            System.out.println(button + " is an invalid mode, please select a valid mode for this register to be used in:");
            System.out.println("1: Cashier mode");
            System.out.println("2: Administrative mode");
            System.out.println("0: Shut Down");
            button = s.nextInt();
        }
        if (button == 0) return;
        switch (button) {
            case 1: {
                while (exit2 == false) {
                    exit1 = false;
                    exit2 = false;
                    CheckoutList ckl = new CheckoutList();
                    System.out.print("Cashier mode accessed. ");
                    while (exit1 == false) {
                        System.out.println("Please select an option:");
                        System.out.println("1: Scan products");
                        System.out.println("2: Remove products");
                        System.out.println("3: Proceed to checkout");
                        button = s.nextInt();
                        while (button < 1 || button > 3) {
                            System.out.println(button + " is not a valid option, please select a valid option:");
                            System.out.println("1: Scan products");
                            System.out.println("2: Remove products");
                            System.out.println("3: Proceed to checkout");
                            button = s.nextInt();
                        }
                        if (button == 1) {
                            while (button != 0) {
                                if (ckl.getNumberOfItems() > 0) {
                                    ckl.showList();
                                    System.out.println("Current total: " + ckl.getTotalPrice());
                                }
                                System.out.println("Input product code to be added to the receipt or 0 to return to root.");
                                button = s.nextInt();
                                if (button == 0) {
                                } else if (pdb.returnProduct(button) != null) {
                                    ckl.addProduct(pdb.returnProduct(button));
                                } else
                                    System.out.println("The product under ID " + button + " is no longer available.");
                            }
                        }
                        if (button == 2) {
                            while (button != 0) {
                                if (ckl.getNumberOfItems() > 0) {
                                    ckl.showList();
                                    System.out.println("Current total: " + ckl.getTotalPrice());
                                } else {
                                    System.out.println("Checkout List is currently empty.");
                                    button = 0;
                                }
                                if (button == 0) {
                                } else {
                                    System.out.println("Input a product code to be removed from the receipt or 0 to return to root.");
                                    button = s.nextInt();
                                    if (button == 0) {
                                    } else ckl.removeProduct(button);
                                }

                            }
                        }
                        if (button == 3) {
                            if (ckl.getNumberOfItems() > 0) {
                                ckl.showList();
                                System.out.println("Current total: " + ckl.getTotalPrice());
                            } else break;
                            System.out.println("Checkout initiated, please select an option:");
                            System.out.println("1: Add a discount and input payment method.");
                            System.out.println("2: Input payment method.");
                            button = s.nextInt();
                            if (button == 1) {
                                System.out.println("Input discount percentage between 1 and 50.");
                                button = s.nextInt();
                                while (button < 1 || button > 50) {
                                    System.out.println("Input a valid discount percentage (between 1 and 50).");
                                    button = s.nextInt();
                                }
                                ckl.inputDiscount(button);
                            }
                            ckl.showList();
                            System.out.println(ckl.getTotalPrice());
                            System.out.println("Please choose a payment method:");
                            System.out.println("1: Cash Payment");
                            System.out.println("2: Card Payment");
                            button = s.nextInt();
                            while (button != 1 && button != 2) {
                                System.out.println("Please choose a valid payment method:");
                                System.out.println("1: Cash Payment");
                                System.out.println("2: Card Payment");
                                button = s.nextInt();
                            }
                            if (button == 1) {
                                pay.addCash(ckl.getTotalPrice());
                                aud.addAction("SaleCash:"+ckl.getTotalPrice());
                                exit1 = true;
                            } else {
                                pay.addCard(ckl.getTotalPrice());
                                aud.addAction("SaleCard:"+ckl.getTotalPrice());
                                exit1 = true;
                            }
                        }
                    }
                    System.out.println("Please select an option:");
                    System.out.println("0: Return to Cashier mode");
                    System.out.println("1: Exit Cashier mode");
                    button = s.nextInt();
                    while (button < 0 || button > 1) {
                        System.out.println("Please select a valid option:");
                        System.out.println("0: Return to Cashier mode");
                        System.out.println("1: Exit Cashier mode");
                        button = s.nextInt();
                    }
                    if (button == 0) exit2 = false;
                    else exit2 = true;
                    if (pay.getNumberOfCardPayments() != 0) {
                        System.out.println(pay.getNumberOfCardPayments() + " card payments have been made, worth a total of " + pay.getValueOfCardPayments() + " RON.");
                    }
                    if (pay.getNumberOfCashPayments() != 0) {
                        System.out.println(pay.getNumberOfCashPayments() + " cash payments have been made, worth a total of " + pay.getValueOfCashPayments() + " RON.");
                    }
                }
            }
            case 2: {
                while (exit2 == false) {
                    System.out.println("Administration mode accessed. Please select an option:");
                    System.out.println("1: Add products to the database");
                    System.out.println("2: Remove products from the database");
                    System.out.println("3: View product database");
                    System.out.println("4: Add clients to the database");
                    System.out.println("5: Remove clients from the database");
                    System.out.println("6: View client database");
                    System.out.println("7: View Audit");
                    button = s.nextInt();
                    while (button < 1 || button > 7) {
                        System.out.println(button + " is not a valid option, please select a valid option:");
                        System.out.println("1: Add products to the database");
                        System.out.println("2: Remove products from the database");
                        System.out.println("3: View product database");
                        System.out.println("4: Add clients to the database");
                        System.out.println("5: Remove clients from the database");
                        System.out.println("6: View client database");
                        System.out.println("7: View Audit");
                        button = s.nextInt();
                    }
                    switch (button) {
                        case 1: {
                            String name;
                            float price;
                            System.out.println("Please input the new product's name.");
                            name = s.next();
                            System.out.println("Please input the new product's price.");
                            price = s.nextFloat();
                            pdb.addProduct(name, price);
                            aud.addAction("AddedProduct:"+name);
                            break;
                        }
                        case 2: {
                            int removepid;
                            System.out.println("Please input the ID of the product you wish to remove.");
                            removepid = s.nextInt();
                            pdb.removeProduct(removepid);
                            aud.addAction("RemovedProductID:"+removepid);
                            break;
                        }
                        case 3: {
                            pdb.showDatabase();
                            aud.addAction("ViewedProductDatabase");
                            break;
                        }
                        case 4: {
                            String name;
                            String surname;
                            int age;
                            System.out.println("Please input the new client's name.");
                            name = s.next();
                            System.out.println("Please input the new client's surname.");
                            surname = s.next();
                            System.out.println("Please input the new client's age.");
                            age = s.nextInt();
                            cdb.addClient(name, surname, age);
                            aud.addAction("AddedClient:"+name+surname);
                            break;
                        }
                        case 5: {
                            int removeid;
                            System.out.println("Please input the ID of the client you wish to remove.");
                            removeid = s.nextInt();
                            cdb.removeClient(removeid);
                            aud.addAction("RemovedClientID:"+removeid);
                            break;
                        }
                        case 6: {
                            cdb.showDatabase();
                            aud.addAction("ViewedClientDatabase");
                            break;
                        }
                        case 7: {
                            aud.addAction("ViewedAudit");
                            aud.showAudit();
                        }
                    }
                    System.out.println("Please select an option:");
                    System.out.println("0: Return to Administrator mode");
                    System.out.println("1: Exit Administrator mode");
                    button = s.nextInt();
                    while (button < 0 || button > 1) {
                        System.out.println("Please select a valid option:");
                        System.out.println("0: Return to Administrator mode");
                        System.out.println("1: Exit Administrator mode");
                        button = s.nextInt();
                    }
                    if (button == 0) exit2 = false;
                    else exit2 = true;
                }
            }
        }
    }
}
