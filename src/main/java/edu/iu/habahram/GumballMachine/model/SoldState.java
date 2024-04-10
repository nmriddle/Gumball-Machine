package edu.iu.habahram.GumballMachine.model;

public class SoldState implements IState {
    IGumballMachine gumballMachine;

    public SoldState(IGumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public TransitionResult insertQuarter() {
//        gumballMachine.changeTheStateTo(GumballMachineState.HAS_QUARTER);
        String message = "Currently vending, cannot insert";
        boolean succeeded = false;
        int count = gumballMachine.getCount();
        return new TransitionResult(succeeded, message, gumballMachine.getTheStateName(), count);
    }

    @Override
    public TransitionResult ejectQuarter() {
        String message = "Currently vending, cannot eject";
        boolean succeeded = false;
        return new TransitionResult(succeeded, message, gumballMachine.getTheStateName(), gumballMachine.getCount());
    }

    @Override
    public TransitionResult turnCrank() {
        String message = "Currently vending, cannot turn";
        boolean succeeded = false;
        return new TransitionResult(succeeded, message, gumballMachine.getTheStateName(), gumballMachine.getCount());
    }

    @Override
    public TransitionResult dispense() {
        String message = "Here you go";
        boolean succeeded = true;
        if (gumballMachine.getCount() == 1) {
            gumballMachine.changeTheStateTo(GumballMachineState.OUT_OF_GUMBALLS);
        } else if (gumballMachine.getCount() > 1) {
            gumballMachine.changeTheStateTo(GumballMachineState.NO_QUARTER);
        }
        return new TransitionResult(succeeded, message, gumballMachine.getTheStateName(), gumballMachine.getCount() - 1);

    }

    @Override
    public String getTheName() {
        return GumballMachineState.NO_QUARTER.name();
    }
}