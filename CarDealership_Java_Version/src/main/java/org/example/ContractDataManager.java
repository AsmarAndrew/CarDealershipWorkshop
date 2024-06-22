package org.example;

import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;


public class ContractDataManager{
    public static void saveContract(Contract contract){
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        try(FileWriter writer = new FileWriter("src/main/resources/Contracts.csv",true)){
            if (contract instanceof SalesContract){
                writer.write("SALE|" + contract.getDateOfContract() + "|" + contract.getCustomerName() + "|" + contract.getCustomerEmail() + "\n");
                writer.write("\t" + contract.getVehicleSold().toString()+"\n");
                writer.write("\t" + ((SalesContract) contract).getSalesTax() + "|" + ((SalesContract) contract).getRecordingFee() + "|" + ((SalesContract) contract).getProcessingFee()+"|" + contract.getTotalPrice() + "|" + ((SalesContract) contract).isFinanced() + "|" + decimalFormat.format(contract.getMonthlyPayment()) + "\n");
            } else if (contract instanceof LeaseContract) {
                writer.write("LEASE|" + contract.getDateOfContract() + "|" + contract.getCustomerName() + "|" + contract.getCustomerEmail() + "\n");
                writer.write("\t" + contract.getVehicleSold().toString()+"\n");
                writer.write("\t" + ((LeaseContract) contract).getExpectedEndingValue() + "|" + ((LeaseContract) contract).getLeaseFee() + "|" + contract.getTotalPrice() + "|" + decimalFormat.format(contract.getMonthlyPayment())+"\n");
            }else {
                writer.write("Unknown Contract Info");
            }

        }catch (IOException ex){
            System.out.println("Error reading inventory file: " + ex.getMessage());
        }
    }

}