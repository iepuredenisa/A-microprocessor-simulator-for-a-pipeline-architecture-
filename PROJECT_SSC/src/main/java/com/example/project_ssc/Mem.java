package com.example.project_ssc;

public class Mem {
    public static int EXMEMindex =0;

    public static void mem() {
        String inst = MainController.EXMEM[EXMEMindex];
        EXMEMindex += 1;
        String pc = MainController.EXMEM[EXMEMindex];
        EXMEMindex +=1;
        String op = MainController.EXMEM[EXMEMindex];
        EXMEMindex += 1;
        String rxBinary = MainController.EXMEM[EXMEMindex];
        EXMEMindex += 1;
        int rx = convertToDecimal(rxBinary);
        String ryBinary = MainController.EXMEM[EXMEMindex];
        EXMEMindex += 1;
        int ry = convertToDecimal(ryBinary);
        String rzBinary = MainController.EXMEM[EXMEMindex];
        EXMEMindex += 1;
        int rz = convertToDecimal(rzBinary);
        String immediate = MainController.EXMEM[EXMEMindex];
        EXMEMindex += 1;
        String signExtendOut = MainController.EXMEM[EXMEMindex];
        EXMEMindex += 1;
        String readData1 = MainController.EXMEM[EXMEMindex];
        EXMEMindex += 1;
        String readData2 = MainController.EXMEM[EXMEMindex];
        EXMEMindex += 1;
        String RegDst = MainController.EXMEM[EXMEMindex];
        EXMEMindex += 1;
        String RegWrite = MainController.EXMEM[EXMEMindex];
        EXMEMindex += 1;
        String PCSrc = MainController.EXMEM[EXMEMindex];
        EXMEMindex += 1;
        String MemRead = MainController.EXMEM[EXMEMindex];
        EXMEMindex += 1;
        String MemWrite = MainController.EXMEM[EXMEMindex];
        EXMEMindex += 1;
        String MemToReg = MainController.EXMEM[EXMEMindex];
        EXMEMindex += 1;
        String ALUresult= MainController.EXMEM[EXMEMindex];
        EXMEMindex += 1;
        String BranchAddressResult = MainController.EXMEM[EXMEMindex];
        EXMEMindex += 1;
        if(op.equals("0000000001")) {
            System.out.println("ADD " + "r" + rx + " r" + ry + " " +convertToDecimal(immediate)+ " in MemoryAccess stage:");
            System.out.println("\n\n");
        }
        if(op.equals("0000000010")) {
            System.out.println("ADDi " + "r" + rx + " r" + ry + " " +convertToDecimal(immediate)+ " in MemoryAccess stage:");
            System.out.println("\n\n");
        }
        if(op.equals("0000000011")) {
            System.out.println("SUB " + "r" + rx + " r" + ry + " " +convertToDecimal(immediate)+ " in MemoryAccess stage:");
            System.out.println("\n\n");
        }
        if(op.equals("0000000100")) {
            System.out.println("MULT " + "r" + rx + " r" + ry + " " +convertToDecimal(immediate)+ " in MemoryAccess stage:");
            System.out.println("\n\n");
        }
        if(op.equals("0000000101")) {
            System.out.println("AND " + "r" + rx + " r" + ry + " " +convertToDecimal(immediate)+ " in MemoryAccess stage:");
            System.out.println("\n\n");
        }
        if(op.equals("0000000110")) {
            System.out.println("ORi " + "r" + rx + " r" + ry + " " +convertToDecimal(immediate)+ " in MemoryAccess stage:");
            System.out.println("\n\n");
        }
        if(op.equals("1000000010")) {
            System.out.println("ANDi " + "r" + rx + " r" + ry + " " +convertToDecimal(immediate)+ " in MemoryAccess stage:");
            System.out.println("\n\n");
        }
        if(op.equals("0000000111")) {
            System.out.println("SLL " + "r" + rx + " r" + ry + " " +convertToDecimal(immediate)+ " in MemoryAccess stage:");
            System.out.println("\n\n");
        }
        if(op.equals("0000001000")) {
            System.out.println("SRL " + "r" + rx + " r" + ry + " " +convertToDecimal(immediate)+ " in MemoryAccess stage:");
            System.out.println("\n\n");
        }
        if(op.equals("0000001001")) {
            System.out.println("Alu result : " + ALUresult);
            // $t  MEM[$s + offset]; PC  PC + 4;
            System.out.println("LW  " + "rt[" + ry + "] <="  + "Mem[rs+offset]=" +MemoryData.dataMem[convertToDecimal(ALUresult)]+" in MemoryAccess stage:");
            System.out.println("\n\n");
        }

        if(op.equals("0000001011")) {
            System.out.println("BNE " + "r" + rx + " r" + ry + " " +convertToDecimal(immediate)+ " in MemoryAccess stage:");
            System.out.println("\n\n");}
//        if(op.equals("0000001100")) {
//            System.out.println("BGT " + "r" + rx + " r" + ry + " " +convertToDecimal(immediate)+ " in MemoryAccess stage:");
//        }
        if(op.equals("0000001101")) {
            System.out.println("SLT " + "r" + rx + " r" + ry + " r" + rz + " in MemoryAccess stage:");


            System.out.println("\n\n");}
        if(op.equals("1000000000")) {
            System.out.println("OR " + "r" + rx + " r" + ry + " r" + rz + " in MemoryAccess stage:");

            System.out.println("\n\n");}
        if(op.equals("1000000001")) {
            System.out.println("XOR " + "r" + rx + " r" + ry + " r" + rz + " in MemoryAccess stage:");

            System.out.println("\n\n");}
        if(op.equals("0000001110")) {
            System.out.println("J " + immediate + " in MemoryAccess stage:");
            System.out.println("\n\n");}
        if(op.equals("0000001010")) {
            //MEM[$s + offset]  $t; PC  PC + 4;
//            Cache.cachestore(RegFile.registers[rt], immediate);
System.out.println(convertToDecimal(ALUresult));
            MemoryData.dataMem[convertToDecimal(ALUresult)]=RegFile.registers[ry];
            System.out.println("SW  " + "Mem[rs+rt]  " + convertToDecimal(ALUresult) + " rt" + RegFile.registers[ry] + " in MemoryAccess stage:");
            System.out.println("memory new data : " + RegFile.registers[convertToDecimal(ALUresult)]);
            System.out.println("ALUresult : " + ALUresult  );
            System.out.println("WB Controls : " + "MemToReg : " + MemToReg + " RegWrite : " + RegWrite);
            System.out.println("MEM Controls : " + "MemRead : " + MemRead + " MemWrite : " + MemWrite + " PCSrc : " + PCSrc);
            System.out.println("EXT Controls : " + "RegDst : " + RegDst );
            System.out.println("\n\n");}
        MainController.MEMWB[MainController.MEMWBindex] = inst;
        MainController.MEMWBindex += 1;
        MainController.MEMWB[MainController.MEMWBindex] = pc;
        MainController.MEMWBindex += 1;
        MainController.MEMWB[MainController.MEMWBindex] = op;
        MainController.MEMWBindex += 1;
        MainController.MEMWB[MainController.MEMWBindex] = convertToBinary(rx);
        MainController.MEMWBindex += 1;
        MainController.MEMWB[MainController.MEMWBindex] = convertToBinary(ry);
        MainController.MEMWBindex += 1;
        MainController.MEMWB[MainController.MEMWBindex] = convertToBinary(rz);
        MainController.MEMWBindex += 1 ;
        MainController.MEMWB[MainController.MEMWBindex] = immediate;
        MainController.MEMWBindex += 1;
        MainController.MEMWB[MainController.MEMWBindex] = signExtendOut;
        MainController.MEMWBindex += 1;
        MainController.MEMWB[MainController.MEMWBindex] = readData1;
        MainController.MEMWBindex += 1;
        MainController.MEMWB[MainController.MEMWBindex] = readData2;
        MainController.MEMWBindex += 1;
        MainController.MEMWB[MainController.MEMWBindex] = RegDst;
        MainController.MEMWBindex += 1;
        MainController.MEMWB[MainController.MEMWBindex] = RegWrite;
        MainController.MEMWBindex += 1;
        MainController.MEMWB[MainController.MEMWBindex] = PCSrc;
        MainController.MEMWBindex += 1;
        MainController.MEMWB[MainController.MEMWBindex] = MemRead;
        MainController.MEMWBindex += 1;
        MainController.MEMWB[MainController.MEMWBindex] = MemWrite;
        MainController.MEMWBindex += 1;
        MainController.MEMWB[MainController.MEMWBindex] = MemToReg;
        MainController.MEMWBindex += 1;
        MainController.MEMWB[MainController.MEMWBindex] = ALUresult;
        MainController.MEMWBindex += 1;
        MainController.MEMWB[MainController.MEMWBindex] = BranchAddressResult;
        MainController.MEMWBindex += 1;
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

    public static String convertToBinary(int n){
        String out = "";
        String zeros = "";
        String z = Integer.toBinaryString(n);
        int rem = 32 - z.length();
        for(int i=0;i<rem;i++) {
            zeros += "0";
        }
        out = zeros + z;
        return out;
    }
}
