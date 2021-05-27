/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sequencial;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Random;
import java.util.UUID;
import java.util.*;
/**
 *
 * @author xxblu
 */
public class Principal  extends java.lang.Thread{
    
    public void salvarArquivo(int seed){
        File farquivo = null;
        FileWriter FW= null;
        PrintWriter PW= null;
        File diretorio = new File("c:\\ArquivoVetor");
        diretorio.mkdir();
        try{
            farquivo = new File(diretorio,"Vetores.txt");
            FW =  new FileWriter(farquivo);
            PW = new PrintWriter(FW); 
            
            Random rand = new Random();
            rand.setSeed(seed);
            
            int i;
            
            for(i=0;i<1000;i++){
                PW.println(Math.abs(rand.nextInt()) + "/" );
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            try{
                if(FW!=null){
                    FW.close();
                }
            }
            catch(Exception e2){
                e2.printStackTrace();
            }
        }      
    }

    public int[] lerArquivo(){
        int v[] = new int[1000];
        int v1[] = new int[1000];
        File Arquivo = null;
        FileReader Fr = null;
        BufferedReader BR = null;
        File farquivo = null;
        File diretorio = new File("c:\\ArquivoVetor");
        diretorio.mkdir();
        try{
            farquivo = new File(diretorio,"Vetores.txt");
            FileWriter fwArquivo = null;
            if(farquivo.exists() == true){
                fwArquivo = new FileWriter(farquivo,true);
            }
            else{
                fwArquivo = new FileWriter(farquivo);
            }
        }
        catch(Exception e){
        }  
        try{
            int j=0;
            
            
            Arquivo = new File("c:\\ArquivoVetor\\Vetores.txt");
            Fr = new FileReader(Arquivo);
            BR = new BufferedReader(Fr);
            int posicao;
            String Ax;
            String Ax1;
            String Linha;  
            String nome;
            int codigo;
            String email;
            int telefone;
            String rua;
            
            String bairro;
            String obs;
            while((Linha = BR.readLine())!= null){
                posicao = Linha.indexOf("/");
                Ax = Linha.substring(0,posicao);
                codigo = new Integer(Ax);
                Linha = Linha.substring(posicao +1);
                obs = Linha;
               
                v[j] = codigo;
                v1[j] = codigo;      
                j++;     
            }      
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            try{
                if(Fr!=null){
                    Fr.close();
                    BR.close();
                }  
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }
              return v;
    }

    private int id, valor, tempo;
    
    public void run(){
        try {
            for(int i=0; i<valor; i++){
                System.out.println("Thread ID:" + id + "  valor:" + i);
                java.lang.Thread.sleep(tempo);
            }
        } catch (Exception ex){
            System.out.println("Thread terminada..."+ ex.getMessage());
        }
    }
}
