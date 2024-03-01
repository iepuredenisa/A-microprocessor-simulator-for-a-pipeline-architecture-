package com.example.project_ssc;

public class MainUnit {
    public static void ContUnit(String op) {
        if(op.equals("0000001001")) {
            //loadWord
            ID.RegDst="0";
            ID.RegWrite="1";
            ID.PCSrc="0";
            ID.MemRead="1";
            ID.MemWrite="0";
            ID.MemToReg="1";
            System.out.println("WB Controls : " + "MemToReg : " + ID.MemToReg + " RegWrite : " + ID.RegWrite);
            System.out.println("MEM Controls : " + "MemRead : " + ID.MemRead + " MemWrite : " + ID.MemWrite + " PCSrc : " + ID.PCSrc);
            System.out.println("EXT Controls : " + "RegDst : " + ID.RegDst );
        }
        if(op.equals("0000001010")) {
//			storeWord
            ID.RegDst="x";
            ID.RegWrite="0";
            ID.PCSrc="0";
            ID.MemRead="0";
            ID.MemWrite="1";
            ID.MemToReg="x";
            System.out.println("WB Controls : " + "MemToReg : " + ID.MemToReg + " RegWrite : " + ID.RegWrite);
            System.out.println("MEM Controls : " + "MemRead : " + ID.MemRead + " MemWrite : " + ID.MemWrite + " PCSrc : " + ID.PCSrc);
            System.out.println("EXT Controls : " + "RegDst : " + ID.RegDst );
        }
        if(op.equals("0000000001")||op.equals("0000000010")||op.equals("0000000011")||op.equals("0000000100")||op.equals("0000000101")||op.equals("0000000110")||op.equals("0000000111")||op.equals("0000001000")||op.equals("0000001101") ||op.equals("1000000000") || op.equals("1000000001") || op.equals("1000000010")) {
            //rest
            if (op.equals("0000000010") || op.equals("0000000110") || op.equals("1000000010") )
            ID.RegDst="0";
            else ID.RegDst="1";
            ID.RegWrite="1";
            ID.PCSrc="0";
            ID.MemRead="0";
            ID.MemWrite="0";
            ID.MemToReg="0";
            System.out.println("WB Controls : " + "MemToReg : " + ID.MemToReg + " RegWrite : " + ID.RegWrite);
            System.out.println("MEM Controls : " + "MemRead : " + ID.MemRead + " MemWrite : " + ID.MemWrite + " PCSrc : " + ID.PCSrc);
            System.out.println("EXT Controls : " + "RegDst : " + ID.RegDst );
        }
        if(op.equals("0000001011") || op.equals("0000001100")) {
            //branch
            ID.RegDst="x";
            ID.RegWrite="0";
            ID.PCSrc="1";
            ID.MemRead="0";
            ID.MemWrite="0";
            ID.MemToReg="x";
            System.out.println("WB Controls : " + "MemToReg : " + ID.MemToReg + " RegWrite : " + ID.RegWrite);
            System.out.println("MEM Controls : " + "MemRead : " + ID.MemRead + " MemWrite : " + ID.MemWrite + " PCSrc : " + ID.PCSrc);
            System.out.println("EXT Controls : " + "RegDst : " + ID.RegDst );
        }
        if(op.equals("0000001110")) {
            //jump
            ID.RegDst="x";
            ID.RegWrite="0";
            ID.PCSrc="1";
            ID.MemRead="0";
            ID.MemWrite="0";
            ID.MemToReg="x";
            System.out.println("WB Controls : " + "MemToReg : " + ID.MemToReg + " RegWrite : " + ID.RegWrite);
            System.out.println("MEM Controls : " + "MemRead : " + ID.MemRead + " MemWrite : " + ID.MemWrite + " PCSrc : " + ID.PCSrc);
            System.out.println("EXT Controls : " + "RegDst : " + ID.RegDst );
        }
    }








}
