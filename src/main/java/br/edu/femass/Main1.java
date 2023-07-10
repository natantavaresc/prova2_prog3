package br.edu.femass;



import java.util.List;

import br.edu.femass.dao.Dao;
import br.edu.femass.entities.Usuario;

public class Main1 {
    public static void main(String[] args) {
            //criarUsuario();
    }

    

    

        

    public static void criarUsuario() {
        Dao<Usuario> daoUsuario = new Dao<>(Usuario.class);        
            Usuario func = new Usuario();
            func.setLogin(String.format("biblioteca111"));
            func.setSenha(String.format("biblioteca111"));
            daoUsuario.create(func);        
    }
        /*

    public static void criarAluno() {
        Dao<Aluno> daoAluno = new Dao<>(Aluno.class);

        for (int i=0;i<10;i++) {
            Aluno func = new Aluno();
            func.setNome(String.format("Nome %d", i));
            func.setMatricula(String.valueOf(i));

            //for (int j=0;j<i;j++) {
            //    func.addSetor(new Setor(String.format("%d%d%d%d",j,j,j,j)));}
            daoAluno.create(func);
        }
    }



    public static void deletarCliente() {
        Dao<Usuario> daoCliente = new Dao<>(Usuario.class);
        daoCliente.delete(1);


    }

    public static void alterarCliente() {
        Dao<Usuario> daoCliente = new Dao<>(Usuario.class);
        Usuario c = daoCliente.findById(2);
        c.setNome("Nome Alterado");
        daoCliente.update(c);

    }
    public static void criarCliente() {
        Dao<Usuario> daoCliente = new Dao<>(Usuario.class);

        for (int i=0;i<10;i++) {
            Usuario cliente = new Usuario();
            cliente.setNome(String.format("Nome %d", i));
            cliente.setEndereco(String.format("Rua %d", i));
            cliente.setCpf(String.valueOf(i));

            for (int j=0;j<i;j++) {
                cliente.addTelefone(new Telefone("22", String.format("%d%d%d%d",j,j,j,j)));
            }
            daoCliente.create(cliente);

        }


    }
    


    }

    public static void imprimirClientes() {
        Dao<Usuario> daoCliente = new Dao<>(Usuario.class);
        List<Usuario> clientes = daoCliente.findAll();

        for (Usuario c: clientes) {
            System.out.println(c);
        }
    }

    public static void buscarPorNome() {
        DaoUsuario daoCliente = new DaoUsuario();
        List<Usuario> clientes = daoCliente.findByName("Nome Alterado");

        for (Usuario c: clientes) {
            System.out.println(c);
        }
    }
    */
}