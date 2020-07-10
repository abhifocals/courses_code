package designpatterns.visitor;

public class Liqor implements Visitable {

    @Override
    public void accept(VisitorInterface visitor) {
            visitor.visit(this);
    }
}
