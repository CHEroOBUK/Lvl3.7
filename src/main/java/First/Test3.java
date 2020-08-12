package First;

public class Test3 {
    @Test(priority = 7)
    public void printTest1(){
        System.out.println("#Test3 <> Print test 1 (priority = 7)");
    }

    @AfterSuite
    public void printTest2(){
        System.out.println("#Test3 <> Print test 2 (AfterSuite)");
    }

    @Test(priority = 1)
    public void printTest3(){
        System.out.println("#Test3 <> Print test 3 (priority = 1)");
    }

    @BeforeSuite
    public void printTest4(){
        System.out.println("#Test3 <> Print test 4 (BeforeSuite)");
    }

    @Test()
    public void printTest5(){
        System.out.println("#Test3 <> Print test 5 with default priority(5)");
    }

    @Test(priority = 4)
    public void printTest6(){
        System.out.println("#Test3 <> Print test 6 (priority = 4)");
    }

    @Test(priority = 9)
    public void printTest7(){
        System.out.println("#Test3 <> Print test 7 (priority = 9)");
    }

}
