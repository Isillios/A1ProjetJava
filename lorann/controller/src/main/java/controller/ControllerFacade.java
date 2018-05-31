package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import fr.exia.insanevehicles.controller.IOrderPerformer;
import fr.exia.insanevehicles.controller.UserOrder;
import fr.exia.insanevehicles.model.IInsaneVehiclesModel;
import fr.exia.insanevehicles.view.IInsaneVehiclesView;
import model.Example;
import model.IModel;
import view.IView;


public class ControllerFacade implements IController {

	private static final int     speed = 300;
	
    private final IView  view;

    private final IModel model;

    private UserOrder stackOrder;
    
    public ControllerFacade(final IView view, final IModel model) {
        super();
        this.view = view;
        this.model = model;
    }

    public void start() throws SQLException {
        this.getView().displayMessage(this.getModel().getExampleById(1).toString());

        this.getView().displayMessage(this.getModel().getExampleByName("Example 2").toString());

        final List<Example> examples = this.getModel().getAllExamples();
        final StringBuilder message = new StringBuilder();
        for (final Example example : examples) {
            message.append(example);
            message.append('\n');
        }
        this.getView().displayMessage(message.toString());
    }

    public final void play() throws InterruptedException {
        while (this.getModel().getMyVehicle().isAlive()) {
            Thread.sleep(speed);
            switch (this.getStackOrder()) {
                case RIGHT:
                    this.getModel().getMyVehicle().moveRight();
                    break;
                case LEFT:
                    this.getModel().getMyVehicle().moveLeft();
                    break;
                case UP:
                    this.getModel().getMyVehicle().moveUp();
                    break;
                case DOWN:
                    this.getModel().getMyVehicle().moveDown();
                    break;
                case SHOOT:
                    this.getModel().getMyVehicle().shoot();
                    break;
                case NOP:
                default:
                    this.getModel().getMyVehicle().doNothing();
                    break;
            }
            this.clearStackOrder();
            if (this.getModel().getMyVehicle().isAlive()) {
                this.getModel().getMyVehicle().moveDown();
            }
        
    }
    
    public final void orderPerform(final UserOrder userOrder) throws IOException {
        this.setStackOrder(userOrder);
    }

    private IView getView() {
        return this.view;
    }

    private void setView(final IView view) {
        this.view = view;
    }

    private IModel getModel() {
        return this.model;
    }

    private void setModel(final IModel model) {
        this.model = model;
    }

    private UserOrder getStackOrder() {
        return this.stackOrder;
    }

    private void setStackOrder(final UserOrder stackOrder) {
        this.stackOrder = stackOrder;
    }

    private void clearStackOrder() {
        this.stackOrder = UserOrder.NOP;
    }

    public controller.IOrderPerformer getOrderPeformer() {
        return this;
    }

}
