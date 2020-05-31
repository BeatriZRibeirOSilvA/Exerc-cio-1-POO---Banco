
package poo1;

import javax.swing.JOptionPane;

public class Banco {
    public int numConta;
    public int agencia;
    public String nome;
    private String senha;
    private double saldo;
    private boolean logado = false;
    
    //gettes e setters
    public int getNumConta() {
        return numConta;
    }

    public void setNumConta(int numConta) {
        this.numConta = numConta;
    }

    public int getAgencia() {
        return agencia;
    }

    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
     public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public boolean isLogado() {  //por que "isLogado"?
        return logado;
    }

    public void setLogado(boolean logado) {
        this.logado = logado;
    }
    
    //metodos
    public boolean logar(int agencia, int numConta, String senha){
        //dados para logar: agencia=2509, conta=1, senha=bia123
        if(agencia == 2509 && numConta == 1 && "bia123".equals(senha)){
            this.logado = true;
            //System.out.println("LOGADO!");
            //System.out.println("Valor da variável logado: " + this.isLogado()); 
            atual(this.logado);
        }
        else{
         JOptionPane.showMessageDialog(null, "DADOS INCORRETOS!");
         this.logado = false;
        }
        return this.logado;
    }
    
    public void atual(boolean logado){
        if(logado == true){
            int opcao;
            opcao = Integer.parseInt(JOptionPane.showInputDialog("Digite:\n"
            + "1- DEPÓSITO\n"
            + "2- SAQUE\n"
            + "3- CONSULTA DE SALDO\n"
            + "4- SAIR"));
            
            switch(opcao){
                case 1:
                    depositar(Double.parseDouble(JOptionPane.showInputDialog("DIGITE O VALOR PARA DEPÓSITO")), this.logado);
                    break;
                    
                case 2:
                    sacar(Double.parseDouble(JOptionPane.showInputDialog("DIGITE O VALOR PARA SAQUE")), this.logado);
                    break;
                    
                case 3:
                    consultarSaldo(this.logado);
                    break;
                    
                case 4:
                    JOptionPane.showMessageDialog(null, "OBRIGADO!\n"
                        + "VOLTE SEMPRE!");
                    System.exit(0);
                    break;
                    
                default:
                    JOptionPane.showMessageDialog(null, "OPÇÃO INVÁLIDA");
            }
        }
    }
    
    public void sacar(double valor, boolean logado){
        this.saldo = this.saldo;
        if(this.saldo < 10){
         JOptionPane.showMessageDialog(null, "Você não tem dinheiro suficiente para realizar saque!");
         String opcao;
          opcao = JOptionPane.showInputDialog("Quer sair agora?\n"
        + "S- Sim\n"
        + "N- Não");
        
        switch(opcao){
            case "S":
                 JOptionPane.showMessageDialog(null, "OBRIGADO!\n"
                + "VOLTE SEMPRE!");
                System.exit(0);
                break;
                
            case "N":
               atual(this.logado);
                break;
                
            default:
                JOptionPane.showMessageDialog(null, "OPÇÃO INVÁLIDA!");
        }
        }
        else{
        
        this.saldo = this.saldo - valor;
        String opcao;
        opcao = JOptionPane.showInputDialog("Tem certeza?\n"
        + "S- Sim\n"
        + "N- Não");
        
        switch(opcao){
            case "S":
                JOptionPane.showMessageDialog(null, "Saque realizado com sucesso!");
                atual(this.logado);
                break;
                
            case "N":
                JOptionPane.showMessageDialog(null, "OBRIGADO!\n"
                + "VOLTE SEMPRE!");
                System.exit(0);
                break;
                
            default:
                JOptionPane.showMessageDialog(null, "OPÇÃO INVÁLIDA!");
        }
        }  
        
    }
    
    public void depositar(double valor, boolean logado){
        this.saldo = this.saldo + valor;
        String opcao;
        opcao = JOptionPane.showInputDialog("Tem certeza?\n"
        + "S- Sim\n"
        + "N- Não");
        
        switch(opcao){
            case "S":
                JOptionPane.showMessageDialog(null, "Depósito realizado com sucesso");
                atual(this.logado);
                break;
                
            case "N":
                JOptionPane.showMessageDialog(null, "OBRIGADO!\n"
                + "VOLTE SEMPRE!");
                System.exit(0);
                break;
                
            default:
                JOptionPane.showMessageDialog(null, "OPÇÃO INVÁLIDA!");
        }
       
    }
    
    public void consultarSaldo(boolean logado){
        JOptionPane.showMessageDialog(null, "O saldo atual de sua conta é de\n"
         + "R$ " + getSaldo());
        String opcao;
        opcao = JOptionPane.showInputDialog("Quer sair agora?\n"
        + "S- Sim\n"
        + "N- Não");
        
        switch(opcao){
            case "S":
                JOptionPane.showMessageDialog(null, "OBRIGADO!\n"
                + "VOLTE SEMPRE!");
                System.exit(0);
               
                break;
                
            case "N":
                atual(this.logado);
                break;
                
            default:
                JOptionPane.showMessageDialog(null, "OPÇÃO INVÁLIDA!");
        }
    }
    
    
}
