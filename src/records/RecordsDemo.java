package records;

import beans.records.Customer;

public class RecordsDemo {

    public static void main(String[] args) {

        var customer = new beans.Customer(101, "Vinay");
        Customer customerRecord = new Customer(312, "Shruti");
        var customer2 = new Customer(412, "Smita");

        System.out.println("customer object = "+customer.toString());
        System.out.println("customer record = "+ customerRecord);

        System.out.println("\n ******* Customer Record details : optimized :) *******");
        System.out.println("Customer id ="+customerRecord.id());
        System.out.println("Customer name ="+customerRecord.name());

        System.out.println("\n ******* Customer details :: Old fashioned :( *******");
        System.out.println("Customer id ="+customer.getId());
        System.out.println("Customer name ="+customer.getName());

        System.out.println("\n ******* Customer Record : equals and hashCode *******");
        System.out.println("customerRecord equals customer2 ?" +customerRecord.equals(customer2));
        System.out.println("customer equals customer2 ?" +customer.equals(customer2));
        System.out.println("\ncustomer hashcode = "+customer.hashCode());
        System.out.println("customer2 hashcode = "+customer2.hashCode());
        System.out.println("customer record hashcode = "+customerRecord.hashCode());


    }
}
