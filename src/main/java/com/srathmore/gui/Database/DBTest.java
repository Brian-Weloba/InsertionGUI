package com.srathmore.gui.Database;

public class DBTest {
    //instantiate the DBImplementation class
    static DBImplemnt db = new DBImplemnt();

    public static void main(String[] args) {
        //run the tests
        testInsert();
        testUpdate();
        testDelete();
        testSelect();
    }

    public static void testInsert() {
        //insert a new record into the persons table and print pass/fail message based on wether the insert threw an exception or not.
        //print the name of the test
        System.out.println("Test 1: Insert a new record into the persons table: ");
        try {
            db.insert("persons",
                    new String[]{"Name", "Gender", "DateOfBirth", "PlaceOfWorkOrSchool", "Residence", "Password"},
                    new String[]{"Paul", "Male", "14-02-1998", "Alliance", "Syokimau", "Test@1234"});
            System.out.println("Pass");
        } catch (Exception e) {
            System.out.println("Fail");
        }
    }

    public static void testUpdate() {
        //update the name of the record in the persons table and print pass/fail message based on wether the update threw an exception or not.
        //print the name of the test
        System.out.println("Test 2: Update the name of the record in the persons table: ");
        try {
            db.update("persons",
                    new String[]{"Name"},
                    new String[]{"Peter"},
                    "Name = 'Paul'");
            System.out.println("Pass");
        } catch (Exception e) {
            System.out.println("Fail");
        }
    }

    //test selection
    public static void testSelect() {
        //select the record in the persons table and print pass/fail message based on wether the select threw an exception or not.
        //print the name of the test
        System.out.println("Test 3: Select the record in the persons table: ");
        try {
            db.select("persons",
                    new String[]{"Name", "Gender", "DateOfBirth", "PlaceOfWorkOrSchool", "Residence", "Password"},
                    "Name = 'Peter'");
            System.out.println("Pass");
        } catch (Exception e) {
            System.out.println("Fail");
        }
    }

    public static void testDelete() {
        //delete the record in the persons table and print pass/fail message based on wether the delete threw an exception or not.
        //print the name of the test
        System.out.println("Test 4: Delete the record in the persons table: ");
        try {
            db.delete("persons", "Name = 'Peter'");
            System.out.println("Pass");
        } catch (Exception e) {
            System.out.println("Fail");
        }
    }
}
