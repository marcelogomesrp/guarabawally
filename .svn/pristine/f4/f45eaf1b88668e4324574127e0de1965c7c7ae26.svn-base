package br.com.guaraba.wally.web.controller.util;

import java.util.Locale;

public class LinguaBackingBean{

    private Locale locale;
    
    /** Creates a new instance of LinguaBackingBean */
    public LinguaBackingBean() {
        locale= new Locale("pt", "BR");
    }

    public Locale getLocale(){
        return this.locale;
    }
    
    public void setLocale(Locale locale){
        this.locale= locale;
    }
    
    public String portugues(){
        locale= new Locale("pt", "BR");
        return "reload";
    }
    
    public String ingles(){
        locale= new Locale("en", "US");
        return "reload";
    }
    
    public String espanhol(){
    	locale = new Locale("es","ES");
    	return "reload";
    }
}