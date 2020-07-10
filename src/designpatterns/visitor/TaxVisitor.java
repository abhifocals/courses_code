package designpatterns.visitor;

public class TaxVisitor implements VisitorInterface {


    @Override
    public String visit(Liqor liquor) {
        return "Added tax to Liqor";
    }
}
