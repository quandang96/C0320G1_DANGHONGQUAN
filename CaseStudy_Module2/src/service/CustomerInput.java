package service;
import exception.ValidationException;
import models.Customer;

import java.util.Scanner;
import java.util.UUID;

public class CustomerInput {
    public static Scanner scanner;
    public static Customer inputNewCustomer(){
            scanner = new Scanner(System.in);
            Customer customer = new Customer();
            customer.setId(UUID.randomUUID().toString().replace("-", ""));
            while (true) {
                try {
                    System.out.print("Enter Name Customer (Format Abc Abc): ");
                    String nameCustomer = ValidationException.nameException(scanner.nextLine());
                    customer.setNameCustomer(nameCustomer);
                    break;
                } catch (Exception m) {
                    System.out.println(m);
                }
            }

            while (true) {
                try {
                    System.out.print("Enter Id Card (Format XXX XXX XXX): ");
                    String idCard = ValidationException.idCardException(scanner.nextLine());
                    customer.setIdCard(idCard);
                    break;
                } catch (Exception m) {
                    System.out.println(m);
                }
            }
            while (true) {
                try {
                    System.out.print("Enter Birthday Customer (Format dd/MM/yyyy): ");
                    String birthdayCustomer = ValidationException.birthdayException(scanner.nextLine());
                    customer.setBirthday(birthdayCustomer);
                    break;
                } catch (Exception m) {
                    System.out.println(m);
                }
            }

            while (true) {
                try {
                    System.out.print("Enter Gender (male, female, unknown): ");
                    String genderCustomer = ValidationException.genderException(scanner.nextLine());
                    customer.setGender(genderCustomer);
                    break;
                } catch (Exception m) {
                    System.out.println(m);
                }
            }


            System.out.print("Enter Phone: ");
            customer.setPhoneNumber(scanner.nextLine());

            while (true) {
                try {
                    System.out.print("Enter Email (Format abc@abc.abc): ");
                    String emailCustomer = ValidationException.emailException(scanner.nextLine());
                    customer.setEmail(emailCustomer);
                    break;
                } catch (Exception m) {
                    System.out.println(m);
                }
            }

            System.out.print("Enter Type Customer: ");
            customer.setTypeCustomer(scanner.nextLine());

            System.out.print("Enter Address: ");
            customer.setAddress(scanner.nextLine());
            System.out.println("------------------------------------------------");

            return customer;
        }

    }

