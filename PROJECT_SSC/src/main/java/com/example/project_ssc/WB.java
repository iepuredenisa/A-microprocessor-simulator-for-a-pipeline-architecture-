package com.example.project_ssc;

public class WB {
    public static String WriteData = "";
    public static int MEMWBindex = 0;
    public static void writeBack() {

        String inst = MainController.MEMWB[MEMWBindex];
        MEMWBindex += 1;
        String pc = MainController.MEMWB[MEMWBindex];
        MEMWBindex +=1;
        String op = MainController.MEMWB[MEMWBindex];
        MEMWBindex -=1;
        MEMWBindex -=1;
        if(op.equals("0000000001")) {
            writeBackALCB();
        }
        if(op.equals("0000000010")) {
            writeBackALCB();
        }
        if(op.equals("0000000011")) {
            writeBackALCB();
        }
        if(op.equals("0000000100")) {
            writeBackALCB();
        }
        if(op.equals("0000000101")) {
            writeBackALCB();
        }
        if(op.equals("0000000110")) {
            writeBackALCB();
        }
        if(op.equals("0000000111")) {
            writeBackALCB();
        }
        if(op.equals("0000001000")) {
            writeBackALCB();
        }
        if(op.equals("0000001011")) {
            writeBackALCB();
        }
        if(op.equals("0000001100")) {
            writeBackALCB();
        }
        if (op.equals("1000000000"))
        {
            writeBackALCB();
        }
        if (op.equals("1000000010"))
        {
            writeBackALCB();
        }
        if (op.equals("1000000001"))
        {
            writeBackALCB();
        }
        if(op.equals("0000001001")) {
            writeBackD();
        }
        if(op.equals("0000001010")) {
            writeBackD();
        }
        if(op.equals("0000001101")) {
            writeBackC();
        }
    }
    public static void writeBackALCB() {
        String inst = MainController.MEMWB[MEMWBindex];
        MEMWBindex += 1;
        String pc = MainController.MEMWB[MEMWBindex];
        MEMWBindex +=1;
        String op = MainController.MEMWB[MEMWBindex];
        MEMWBindex += 1;
        String rxBinary = MainController.MEMWB[MEMWBindex];
        MEMWBindex += 1;
        int rx = convertToDecimal(rxBinary);
        String ryBinary = MainController.MEMWB[MEMWBindex];
        MEMWBindex += 1;
        int ry = convertToDecimal(ryBinary);
        String rzBinary = MainController.MEMWB[MEMWBindex];
        MEMWBindex += 1;
        int rz = convertToDecimal(rzBinary);
        String immediate = MainController.MEMWB[MEMWBindex];
        MEMWBindex += 1;
        String signExtendOut = MainController.MEMWB[MEMWBindex];
        MEMWBindex += 1;
        String readData1 = MainController.MEMWB[MEMWBindex];
        MEMWBindex += 1;
        String readData2 = MainController.MEMWB[MEMWBindex];
        MEMWBindex += 1;
        String RegDst = MainController.MEMWB[MEMWBindex];
        MEMWBindex += 1;
        String RegWrite = MainController.MEMWB[MEMWBindex];
        MEMWBindex += 1;
        String PCSrc = MainController.MEMWB[MEMWBindex];
        MEMWBindex += 1;
        String MemRead = MainController.MEMWB[MEMWBindex];
        MEMWBindex += 1;
        String MemWrite = MainController.MEMWB[MEMWBindex];
        MEMWBindex += 1;
        String MemToReg = MainController.MEMWB[MEMWBindex];
        MEMWBindex += 1;
        String ALUresult= MainController.MEMWB[MEMWBindex];
        MEMWBindex += 1;
        String BranchAddressResult = MainController.MEMWB[MEMWBindex];
        MEMWBindex += 1;

        int immediateDec = convertToDecimal(immediate);
        if(op.equals("0000000001")) {
            System.out.println("ADD " + "r" + rx + " r" + ry + " " +immediateDec + " in WriteBack stage:");
            RegFile.registers[immediateDec] = ALUresult;
            WriteData = ALUresult;
            System.out.println("RD " + immediateDec + "register new value " +   RegFile.registers[immediateDec]);
            System.out.println("ALUres " +ALUresult);

        }
        if(op.equals("0000000010")) {
            System.out.println("ADDi " + "r" + rx + " r" + ry + " " +immediateDec + " in WriteBack stage:");
            RegFile.registers[ry] = ALUresult;
            WriteData = ALUresult;
            System.out.println("RT"+ ry +" register new value " +   RegFile.registers[ry]);
            System.out.println("ALUres " +ALUresult);

        }
        if(op.equals("0000000011")) {
            System.out.println("SUB " + "r" + rx + " r" + ry + " " +immediateDec + " in WriteBack stage:");
            RegFile.registers[immediateDec] = ALUresult;
            WriteData = ALUresult;
            System.out.println("RD " + immediateDec + "register new value " +   RegFile.registers[immediateDec]);
            System.out.println("ALUres " +ALUresult);


        }
        if(op.equals("0000000100")) {
            System.out.println("MULT " + "r" + rx + " r" + ry + " " +immediateDec + " in WriteBack stage:");
            RegFile.registers[immediateDec] = ALUresult;
            WriteData = ALUresult;
            System.out.println("RD " + immediateDec + "register new value " +   RegFile.registers[immediateDec]);
            System.out.println("ALUres " +ALUresult);


        }
        if(op.equals("0000000101")) {
            System.out.println("AND " + "r" + rx + " r" + ry + " " +immediateDec + " in WriteBack stage:");
            RegFile.registers[immediateDec] = ALUresult;
            WriteData = ALUresult;
            System.out.println("RD " + immediateDec + "register new value " +   RegFile.registers[immediateDec]);

            System.out.println("ALUres " +ALUresult);

        }
        if(op.equals("0000000110")) {
            System.out.println("ORi " + "r" + rx + " r" + ry + " " + immediateDec + " in WriteBack stage:");
            RegFile.registers[ry] = ALUresult;
            WriteData = ALUresult;
            System.out.println("RT" + ry + " register new value " + RegFile.registers[ry]);
            System.out.println("ALUres " + ALUresult);
        }
        if(op.equals("1000000010")) {
            System.out.println("ANDi " + "rS " + rx + " rT " + ry + " rD " +immediateDec + " in WriteBack stage:");
            RegFile.registers[ry] = ALUresult;
            WriteData = ALUresult;
            System.out.println("RT"+ ry +" register new value " +   RegFile.registers[ry]);
            System.out.println("ALUres " +ALUresult);

        }
        if(op.equals("1000000000")) {
            System.out.println("OR " + "rS " + rx + " rT " + ry + " rD " +rz + " in WriteBack stage:");
            RegFile.registers[rz] = ALUresult;
            WriteData = ALUresult;
            System.out.println("RD"+ rz +" register new value " +   RegFile.registers[rz]);
            System.out.println("ALUres " +ALUresult);

        }
        if(op.equals("1000000001")) {
            System.out.println("XOR " + "rS " + rx + " rT " + ry + " rD " +rz + " in WriteBack stage:");
            RegFile.registers[rz] = ALUresult;
            WriteData = ALUresult;
            System.out.println("RD"+ rz +" register new value " +   RegFile.registers[rz]);
            System.out.println("ALUres " +ALUresult);

        }
        if(op.equals("0000000111")) {
            System.out.println("SLL " + "r" + rx + " r" + ry + " " +immediateDec + " in WriteBack stage:");
            RegFile.registers[rx] = ALUresult;
            WriteData = ALUresult;
            System.out.println("RD " + rx + "register new value " +   RegFile.registers[rx]);

            System.out.println("ALUres " +ALUresult);

        }
        if(op.equals("0000001000")) {
            System.out.println("SRL " + "r" + rx + " r" + ry + " " +immediateDec + " in WriteBack stage:");
            RegFile.registers[rx] = ALUresult;
            WriteData = ALUresult;
            System.out.println("RD " + rx + "register new value " +   RegFile.registers[rx]);

            System.out.println("ALUres " +ALUresult);

        }
        if(op.equals("0000001011")) {
            System.out.println("BNE " + "r" + rx + " r" + ry + " " +convertToDecimal(immediate)+ " in WriteBack stage:");
            return;
        }
//        if(op.equals("0000001100")) {
//            System.out.println("BGT " + "r" + rx + " r" + ry + " " +convertToDecimal(immediate)+ " in WriteBack stage:");
//            return;
//        }

        System.out.println("WB Controls : " + "MemToReg : " + MemToReg + " RegWrite : " + RegWrite);
        System.out.println("MEM Controls : " + "MemRead : " + MemRead + " MemWrite : " + MemWrite + " PCSrc : " + PCSrc);
        System.out.println("EXT Controls : " + "RegDst : " + RegDst );
        System.out.println("\n\n");

    }

    public static void writeBackD() {
        String inst = MainController.MEMWB[MEMWBindex];
        MEMWBindex += 1;
        String pc = MainController.MEMWB[MEMWBindex];
        MEMWBindex +=1;
        String op = MainController.MEMWB[MEMWBindex];
        MEMWBindex += 1;
        String rxBinary = MainController.MEMWB[MEMWBindex];
        MEMWBindex += 1;
        int rx = convertToDecimal(rxBinary);
        String ryBinary = MainController.MEMWB[MEMWBindex];
        MEMWBindex += 1;
        int ry = convertToDecimal(ryBinary);
        String rzBinary = MainController.MEMWB[MEMWBindex];
        MEMWBindex += 1;
        int rz = convertToDecimal(rzBinary);
        String immediate = MainController.MEMWB[MEMWBindex];
        MEMWBindex += 1;
        String signExtendOut = MainController.MEMWB[MEMWBindex];
        MEMWBindex += 1;
        String readData1 = MainController.MEMWB[MEMWBindex];
        MEMWBindex += 1;
        String readData2 = MainController.MEMWB[MEMWBindex];
        MEMWBindex += 1;
        String RegDst = MainController.MEMWB[MEMWBindex];
        MEMWBindex += 1;
        String RegWrite = MainController.MEMWB[MEMWBindex];
        MEMWBindex += 1;
        String PCSrc = MainController.MEMWB[MEMWBindex];
        MEMWBindex += 1;
        String MemRead = MainController.MEMWB[MEMWBindex];
        MEMWBindex += 1;
        String MemWrite = MainController.MEMWB[MEMWBindex];
        MEMWBindex += 1;
        String MemToReg = MainController.MEMWB[MEMWBindex];
        MEMWBindex += 1;
        String ALUresult= MainController.MEMWB[MEMWBindex];
        MEMWBindex += 1;
        String BranchAddressResult = MainController.MEMWB[MEMWBindex];
        MEMWBindex += 1;

        if(op.equals("0000001010")) {
            System.out.println("SW  " + "memory new value " +   ry + " in WriteBack stage:");
            return;
        }
        // $t  MEM[$s + offset]; PC  PC + 4;

        int address2 = convertToDecimal(immediate);
        System.out.println(convertToDecimal(ALUresult));
        System.out.println(MemoryData.dataMem[convertToDecimal(ALUresult)]);
        RegFile.registers[ry] = MemoryData.dataMem[convertToDecimal(ALUresult)];
        WriteData =  MemoryData.dataMem[convertToDecimal(ALUresult)];
        System.out.println("LW  " + "rt " + ry + " MEM[rs+offser]" +ALUresult + " in WriteBack stage:");
        System.out.println("rt new data : " + convertToDecimal(RegFile.registers[ry]));
        System.out.println("ALUresult : " + ALUresult );
        System.out.println("WB Controls : " + "MemToReg : " + MemToReg + " RegWrite : " + RegWrite);
        System.out.println("MEM Controls : " + "MemRead : " + MemRead + " MemWrite : " + MemWrite + " PCSrc : " + PCSrc);
        System.out.println("EXT Controls : " + "RegDst : " + RegDst );
        System.out.println("\n\n");
    }

    public static void writeBackC() {
        String inst = MainController.MEMWB[MEMWBindex];
        MEMWBindex += 1;
        String pc = MainController.MEMWB[MEMWBindex];
        MEMWBindex +=1;
        String op = MainController.MEMWB[MEMWBindex];
        MEMWBindex += 1;
        String rxBinary = MainController.MEMWB[MEMWBindex];
        MEMWBindex += 1;
        int rx = convertToDecimal(rxBinary);
        String ryBinary = MainController.MEMWB[MEMWBindex];
        MEMWBindex += 1;
        int ry = convertToDecimal(ryBinary);
        String rzBinary = MainController.MEMWB[MEMWBindex];
        MEMWBindex += 1;
        int rz = convertToDecimal(rzBinary);
        String immediate = MainController.MEMWB[MEMWBindex];
        MEMWBindex += 1;
        String signExtendOut = MainController.MEMWB[MEMWBindex];
        MEMWBindex += 1;
        String readData1 = MainController.MEMWB[MEMWBindex];
        MEMWBindex += 1;
        String readData2 = MainController.MEMWB[MEMWBindex];
        MEMWBindex += 1;
        String RegDst = MainController.MEMWB[MEMWBindex];
        MEMWBindex += 1;
        String RegWrite = MainController.MEMWB[MEMWBindex];
        MEMWBindex += 1;
        String PCSrc = MainController.MEMWB[MEMWBindex];
        MEMWBindex += 1;
        String MemRead = MainController.MEMWB[MEMWBindex];
        MEMWBindex += 1;
        String MemWrite = MainController.MEMWB[MEMWBindex];
        MEMWBindex += 1;
        String MemToReg = MainController.MEMWB[MEMWBindex];
        MEMWBindex += 1;
        String ALUresult= MainController.MEMWB[MEMWBindex];
        MEMWBindex += 1;
        String BranchAddressResult = MainController.MEMWB[MEMWBindex];
        MEMWBindex += 1;
        RegFile.registers[rz] = ALUresult;
        WriteData = ALUresult;
        System.out.println("SLT " + "r" + rx+ " r" + ry + " r" + rz + " in WriteBack stage:");
        System.out.println("rd new data : " + RegFile.registers[rz]);
        System.out.println("ALUresult : " + ALUresult );
        System.out.println("WB Controls : " + "MemToReg : " + MemToReg + " RegWrite : " + RegWrite);
        System.out.println("MEM Controls : " + "MemRead : " + MemRead + " MemWrite : " + MemWrite + " PCSrc : " + PCSrc);
        System.out.println("EXT Controls : " + "RegDst : " + RegDst );
        System.out.println("\n\n");
    }


    public static int convertToDecimal(String s){
        int result=0;
        int c=0;
        for(int i=s.length()-1;i>-1;i--) {
            String k = "";
            char h = s.charAt(i);
            k+=h;
            result += (Math.pow(2,c)*Integer.parseInt(k));
            c++;
        }
        return result;
    }
}
