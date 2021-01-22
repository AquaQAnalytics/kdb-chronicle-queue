package com.kdb.adapter.messages;

import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Arrays;

@Getter
@Setter
public class KdbEnvelope implements AdapterMessage {

    private Object[] envelope;
    private int envelopeDepth;
    private Timestamp[] chrontime;
    private String[] sym;
    private double[] bid;
    private double[] bSize;
    private double[] ask;
    private double[] aSize;
    private String[] bex;
    private String[] aex;

    public KdbEnvelope(){
        envelope = new Object[]{};
        envelopeDepth = 0;
        chrontime = new Timestamp[]{};
        sym = new String[]{};
        bid = new double[]{};
        bSize = new double[]{};
        ask = new double[]{};
        aSize = new double[]{};
        bex = new String[]{};
        aex = new String[]{};
    }

    public void reset(){
        envelope = null;
        chrontime = null;
        sym = null;
        bid = null;
        bSize = null;
        ask = null;
        aSize = null;
        bex = null;
        aex = null;

        envelope = new Object[]{};
        envelopeDepth = 0;
        chrontime = new Timestamp[]{};
        sym = new String[]{};
        bid = new double[]{};
        bSize = new double[]{};
        ask = new double[]{};
        aSize = new double[]{};
        bex = new String[]{};
        aex = new String[]{};
    }

    public Timestamp[] addElement(Timestamp[] srcArray, Timestamp elementToAdd) {
        Timestamp[] destArray = Arrays.copyOf(srcArray, srcArray.length + 1);
        destArray[destArray.length - 1] = elementToAdd;
        return destArray;
    }

    public String[] addElement(String[] srcArray, String elementToAdd) {
        String[] destArray = Arrays.copyOf(srcArray, srcArray.length + 1);
        destArray[destArray.length - 1] = elementToAdd;
        return destArray;
    }

    public double[] addElement(double[] srcArray, double elementToAdd) {
        double[] destArray = Arrays.copyOf(srcArray, srcArray.length + 1);
        destArray[destArray.length - 1] = elementToAdd;
        return destArray;
    }

    public void addToEnvelope(KdbMessage kdbMessage){

        chrontime = addElement(chrontime, Timestamp.valueOf(kdbMessage.getTime()));
        sym = addElement(sym, kdbMessage.getSym());
        bid = addElement(bid, kdbMessage.getBid());
        bSize = addElement(bSize, kdbMessage.getBsize());
        ask = addElement(ask, kdbMessage.getAsk());
        aSize = addElement(aSize, kdbMessage.getAssize());
        bex = addElement(bex, kdbMessage.getBex());
        aex = addElement(aex, kdbMessage.getAex());

        envelopeDepth++;

    }

    @Override
    public String toString() {
        return envelope.toString();
    }

    public Object[] toObjectArray() {
        envelope = new Object[] {chrontime, sym, bid, bSize, ask, aSize, bex, aex};
        return envelope;
    }
}
