import java.util.HashMap;

import espest.Operador;
import espest.OperadorGeral;
import espest.Transicao;


public class MecProcPDM<E> {

	private ModeloPDM<E> modelo;
	private double gamma;
	private double epsilon;
	public HashMap<E,Double> u;
	private HashMap<E,Double> uAnt;
	private double delta;
	
	public MecProcPDM(double epsilon, double gamma, ModeloPDM<E> modelo){
		
		this.epsilon = epsilon;
		this.gamma = gamma;
		this.modelo = modelo;
		
		u = new HashMap<E, Double>();
		uAnt = new HashMap<E, Double>();
	}

	public HashMap<E, Operador<E>> planearPolitica(){
		
		iterarUtilidade();
		return gerarPolitica();
	}
	
	
	private void iterarUtilidade(){
		
		Transicao<E> trans;
		double us, usAnt, du;
		
		// Inicializar o modelo
		for(E s : modelo.s()){
			u.put(s, 0.0);				
		}
		do{
			// guardar modelo para nova itera��o
			for(E s : modelo.s()){
				uAnt.put(s, u.get(s));
			}
			
			delta = 0;
			
			for(E s : modelo.s()){
				trans = maxTrans(s, uAnt);
				
				if(trans != null){// null significa a posi��o de um obstaculo
					us = utilTrans(trans, uAnt);
					usAnt=u.put(s, us);
					du=Math.abs(us-usAnt);
					if(du>delta)
						delta=du;
				}
			}
			
		}while(delta > (epsilon*(1-gamma)/gamma));
		
	}
	//utilidade da transi��o
	private double utilTrans(Transicao<E> trans, HashMap<E, Double> u){
		
		// s linha
		E sn = trans.obterEstadoSuc();
		// utilidade de s linha
		double usn = u.get(sn);
		// a probabilidade de ir para s linha
		double t = modelo.t(trans);
		// a recompensa de ir para s linha
		double r = modelo.r(trans);

		return t*(r+gamma*usn);
	}
	
	private Transicao<E> maxTrans(E s, HashMap<E, Double> u){
		
		double uMax = Double.NEGATIVE_INFINITY;
		Transicao<E> transMax = null;
		
		for(OperadorGeral<E> oper : modelo.o(s))
			for(Transicao<E> trans : oper.aplicar(s)){
				
				double utrans = utilTrans(trans, u);
				if(utrans > uMax){
					uMax = utrans;
					transMax = trans;
				}
			}
		
		return transMax;
			
	}

	private HashMap<E, Operador<E>> gerarPolitica(){
		
		HashMap<E, Operador<E>> politica = new HashMap<E, Operador<E>>();
		
		for(E s : modelo.s()){
			
			Transicao<E> trans = maxTrans(s, u);
			if(trans != null)//obstaculos
				politica.put(s, trans.obterOperador());
		}
		
		return politica;
	}
}
