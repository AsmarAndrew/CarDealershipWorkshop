package org.example;

public class SalesContract extends Contract {
    private double salesTax;
    private double recordingFee;
    private double processingFee;
    private boolean financeOption;

    public SalesContract(String date, String customerName, String customerEmail, Vehicle vehicleSold,
                         boolean financeOption) {
        super(date, customerName, customerEmail, vehicleSold);
        this.salesTax = salesTax;
        this.recordingFee = recordingFee;
        this.processingFee = processingFee;
        this.financeOption = financeOption;
    }


    public double getSalesTax() {
        salesTax = getVehicleSold().getPrice() * 0.05;
        return salesTax;
    }

    public void setSalesTax(double salesTax) {
        this.salesTax = salesTax;
    }

    public double getRecordingFee() {
        recordingFee = 100;
        return recordingFee;
    }

    public void setRecordingFee(double recordingFee) {
        this.recordingFee = recordingFee;
    }

    public double getProcessingFee() {
        if (getVehicleSold().getPrice() < 10000){
            processingFee = 295;
        }else {
            processingFee = 495;
        }
        return processingFee;
    }

    public void setProcessingFee(double processingFee) {
        this.processingFee = processingFee;
    }

    public boolean isFinanceOption() {
        return financeOption;
    }

    public void setFinanceOption(boolean financeOption) {
        this.financeOption = financeOption;
    }

    public String isFinanced(){
        if (isFinanceOption()){
            return "YES";
        }else {
            return "NO";
        }
    }

    @Override
    public double getTotalPrice() {
        return salesTax + recordingFee + processingFee + getVehicleSold().getPrice();
    }

    @Override
    public double getMonthlyPayment() {
        double month1 = 0.0425 / 12;
        double month2 = 0.0525 / 12;

        if (isFinanceOption()){
            if (getVehicleSold().getPrice() >= 10000){
                double numerator = (getVehicleSold().getPrice() * month1) * Math.pow(1 + month1, 48);
                double denominator = Math.pow(1 + month1, 48)-1;
                return (numerator / denominator);

            }else {
                double numerator = (getVehicleSold().getPrice() * month2) * Math.pow(1 + month2, 24);
                double denominator = Math.pow(1 + month2, 24)-1;
                return (numerator / denominator);
            }

        }else {
            return 0;
        }

    }
}