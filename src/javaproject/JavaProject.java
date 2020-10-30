
package javaproject;
import java.util.Arrays;
import java.util.Scanner;

public class JavaProject {
    
    private static String[] nomes;
    private static float[] av1;
    private static float[] av2;
    //private static float[] medias;
    
    private static final int QTDETOT = 100;
   

    private static float calcularMedia(int id) {
        return (av1[id] + av2[id]) /2;
    }

    
    
    private static void imprimir(int id){
        float medias = calcularMedia(id);
                
        String situacao = null;
        if(medias <= 4 ) {
            situacao = "Reprovado";
        }else {
        situacao = "Aprovado";
        }
        System.out.printf("{%d} Nome do Aluno: %s Nota AV1: %.2f Nota AV2: %.2f, Media do aluno: %.2f Status do Aluno: %s\n", id, nomes[id], av1[id], av2[id], medias, situacao);
    }
        //return medias[id]
    //}
    
    private static void imprimir() {
        for(int i = 0; i < QTDETOT; i++) {
            if(nomes[i] != null) {
                imprimir(i);
            }
        }
    }
    
    
    public static void main(String[] args) {
        nomes = new String[QTDETOT];
        av1 = new float[QTDETOT];
        av2 = new float[QTDETOT];
        
        Scanner in = new Scanner(System.in);
        
        // Arrays Início
        
        Integer[] opcoes = {1,2,3,4};
        
        int i = 0;
        int opcao;
        do {
            System.out.println("[1] Registrar as notas de um novo aluno.");
            System.out.println("[2] Consultar boletim de um aluno.");
            System.out.println("[3] Consultar notas da turma.");
            System.out.println("[4] Sair.");
            System.out.println("Informe a opção desejada: ");
            
            opcao = in.nextInt();
            
            if(Arrays.asList(opcoes).contains(opcao)) {
                if(opcao == 1) {
                    
                    if(i < QTDETOT) {
                        System.out.println("Informe o nome do Aluno: ");
                        nomes[i] = in.next();
                        
                    
                        System.out.println("Informe a Nota AV1: ");
                        av1[i] = in.nextFloat();
                        
                        System.out.println("Informe a Nota AV2:");
                        av2[i] = in.nextFloat();
                        
                        
                        System.out.println("........... Aluno cadastrado ...........");
                        imprimir(i);
                        System.out.println("........... com Sucesso! ...........");
                        
                        i++;
                    } else {
                        System.out.println("Impossível cadastrar um novo aluno!");
                    }
                    
                }else if (opcao == 2) {
                    System.out.println("Informe a identificação do aluno: ");
                    int id = in.nextInt();
                    
                    if(id >=0 && id < i) {
                        System.out.println("--- Aluno ---");
                        imprimir(id);
                        System.out.println("-------------");
                    } else {
                        System.out.println("Identificação Inexistente!!!");
                        
                    }
                            
                  }else if(opcao == 3) {
                      System.out.println("--- Lista de Alunos ---");
                      imprimir();
                      System.out.println("-----------------------");
                }
            }else{
                System.out.println("Opção Inexistente!!!");
            }
            
        }while(opcao != 4);
        System.out.println("Sistema finalizado com Sucesso!!!");
        
        in.close();
        
        
    }
    
}
