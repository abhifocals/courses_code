package designpatterns.visitor;

public class TestVisitor {

    public static void main(String[] args) {

        TaxVisitor taxVisitor = new TaxVisitor();
        Liqor liqor = new Liqor();

        System.out.println(taxVisitor.visit(liqor));
    }






}
