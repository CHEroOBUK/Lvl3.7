package First;

public class Test1 {
    @Test(priority = 2)
    public void printTest1(){
        System.out.println("#Test1 <> Print test 1 (priority = 2)");
    }

    @BeforeSuite
    public void printTest2(){
        System.out.println("#Test1 <> Print test 2 (BeforeSuite)");
    }

    @Test(priority = 6)
    public void printTest3(){
        System.out.println("#Test1 <> Print test 3 (priority = 6)");
    }

    @AfterSuite
    public void printTest4(){
        System.out.println("#Test1 <> Print test 4 (AfterSuite)");
    }

    @Test()
    public void printTest5(){
        System.out.println("#Test1 <> Print test 5 with default priority(5)");
    }

    @Test(priority = 8)
    public void printTest6(){
        System.out.println("#Test1 <> Print test 6 (priority = 8)");
    }

    @Test()
    public void printTest7(){
        System.out.println("#Test1 <> Print test 7 with default priority(5)");
    }

}
