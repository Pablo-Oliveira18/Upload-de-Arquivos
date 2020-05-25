package File;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;


@ManagedBean (name = "mb")
@Named
@RequestScoped
public class FileUploadView {
    
    private String conteudoDoArquivo;
     
    private UploadedFile file;

    public UploadedFile getFile() {
        return file;
    }
 
    public void setFile(UploadedFile file) {
        this.file = file;
    }
 

    public void upload() throws IOException{ 
        if (file != null) {
            if(file.getSize() > 102400){
                FacesMessage message = new FacesMessage("Erro !", file.getFileName() + " é maior que o permitido ! !");
                FacesContext.getCurrentInstance().addMessage(null, message);

            }
            FacesMessage message = new FacesMessage("Sucesso !", file.getFileName() + " foi verificado com sucesso !");
            FacesContext.getCurrentInstance().addMessage(null, message);
            conteudoDoArquivo = new Scanner(file.getInputstream(), "UTF-8").useDelimiter("\\A").next();
        }else{
            FacesMessage message = new FacesMessage("Erro !", "Nenhum arquivo selecionado");
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }
     
     

    public String conteudo(){
        return conteudoDoArquivo;
    }

    public String getConteudoDoArquivo() {
        return conteudoDoArquivo;
    }

    public void setConteudoDoArquivo(String conteudoDoArquivo) {
        this.conteudoDoArquivo = conteudoDoArquivo;
    }
    
    
}