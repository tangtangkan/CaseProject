package com.ttk.test;

public class Middleware {

    private Middleware next;

    private int a;

    /**
     * Builds chains of middleware objects.
     */
    public static Middleware link(Middleware first, Middleware... chain) {
        Middleware head = first;
        for (Middleware nextInChain : chain) {
            head.next = nextInChain;
            head = nextInChain;
        }
        return first;
    }

    /**
     * Subclasses will implement this method with concrete checks.
     */
    // public abstract boolean check(String email, String password);
    //
    // /**
    //  * Runs check on the next object in chain or ends traversing if we're in
    //  * last object in chain.
    //  */
    // protected boolean checkNext(String email, String password) {
    //     if (next == null) {
    //         return true;
    //     }
    //     return next.check(email, password);
    // }


    public Middleware getNext() {
        return next;
    }

    public void setNext(Middleware next) {
        this.next = next;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }
}