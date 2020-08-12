package First;

public class Test2 {

    @AfterSuite
    public void printTest1(){
        System.out.println("#Test2 <> Print test 1");
    }

    @BeforeSuite
    public void printTest2(){
        System.out.println("#Test2 <> Print test 2");
    }

    @Test(priority = 1)
    public void printTest3(){
        System.out.println("#Test2 <> Print test 3");
    }

    @AfterSuite
    public void printTest4(){
        System.out.println("#Test2 <> Print test 4");
    }

    @Test()
    public void printTest5(){
        System.out.println("#Test2 <> Print test 5");
    }

}
