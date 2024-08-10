
package DAO;

import Bean.Pessoa;
import com.db4o.Db4oEmbedded;
import com.db4o.ObjectSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
/**
 *
 * @author andre
 */
public class DaoPessoa {
    public void gravar(Pessoa p){
        com.db4o.ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "banco");
        try{
            db.store(p);
        }finally{
            db.close();
            JOptionPane.showMessageDialog(null, "pessoa cadastrada");
        }
    }
    
    public void deletar(Pessoa p){
        com.db4o.ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "banco");
        try{
            ObjectSet<Pessoa> result = db.queryByExample(p);
            Pessoa found = (Pessoa)result.next();
            db.delete(found);
        }finally{
            db.close();
            JOptionPane.showMessageDialog(null, "Pessoa deletada");
        }
    }
    public void atualizar(Pessoa p) {
        com.db4o.ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "banco");
        try {
            ObjectSet<Pessoa> result = db.queryByExample(p);
            Pessoa found = (Pessoa) result.next();

            found.setNome(p.getNome());
            found.setCpf(p.getCpf());
            found.setCurso(p.getCurso());
            found.setEmail(p.getEmail());
            found.setIdade(p.getIdade());

            db.store(found); 
        } finally {
            db.close();
            JOptionPane.showMessageDialog(null, "Pessoa atualizada");
        }
    }
    
    public ArrayList<Pessoa> pesquisar(String termoPesquisa) {
        com.db4o.ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "banco");
        ArrayList<Pessoa> resultados = new ArrayList<>();
        try {
            Pessoa exemplo = new Pessoa();
            exemplo.setCpf(termoPesquisa);
            ObjectSet<Pessoa> queryByExample = db.queryByExample(exemplo);
            while (queryByExample.hasNext()) {
                Pessoa pessoa = queryByExample.next();
                resultados.add(pessoa);
            }
        } finally {
            db.close();
        }
        return resultados;
    }
    
    public ArrayList<Pessoa> listarTudo(){
        com.db4o.ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "banco");
        ArrayList<Pessoa> lista = new ArrayList();
        try{
            Pessoa p = new Pessoa();
            ObjectSet<Pessoa> queryByExample = db.queryByExample(p);
            while(queryByExample.hasNext()){
                Pessoa pessoa = queryByExample.next();
                lista.add(pessoa);
            }
        }finally{
            db.close();
            return lista;
        }
    }
    
}
