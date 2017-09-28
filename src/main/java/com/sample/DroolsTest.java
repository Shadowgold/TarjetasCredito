package com.sample;

import org.drools.core.event.DebugAgendaEventListener;
import org.kie.api.KieServices;
import org.kie.api.event.rule.DebugRuleRuntimeEventListener;
import org.kie.api.logger.KieRuntimeLogger;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

/**
 * This is a sample class to launch a rule.
 */
public class DroolsTest {

    public static final void main(String[] args) {
        try {
            // load up the knowledge base
	        KieServices ks = KieServices.Factory.get();
    	    KieContainer kContainer = ks.getKieClasspathContainer();
        	KieSession kSession = kContainer.newKieSession("ksession-rules");

        	/*kSession.addEventListener( new DebugAgendaEventListener() );
        	kSession.addEventListener( new DebugRuleRuntimeEventListener() );
        	// To setup a file based audit logger, uncomment the next line
        	KieRuntimeLogger logger = ks.getLoggers().newFileLogger( kSession,"./helloworld" );*/
            // go !
            
            Cliente c1 = new Cliente();
            Cliente c2 = new Cliente();
            Cliente c3 = new Cliente();
            Tarjeta t1 = new Tarjeta();
            Tarjeta t2 = new Tarjeta();
            Pago p1 = new Pago();
            Pago p2 = new Pago();
            Pago p3 = new Pago();
            t1.setNombreT("Visa");
            t2.setNombreT("Mastercard");
            c1.setName("Agustin");
            c1.setPago(p1);
            c1.setTarjeta(t1);
            c2.setName("Meli");
            c2.setPago(p2);
            c2.setTarjeta(t2);
            c3.setName("Maxi");
            c3.setPago(p3);
            c3.setTarjeta(t1);
            kSession.insert(c1);
            kSession.insert(c2);
            kSession.insert(c3);
           kSession.insert(p1);
            kSession.insert(p2);
            kSession.insert(p3);
            kSession.insert(t1);
            kSession.insert(t2);
            kSession.fireAllRules();
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }

    public static class Message {

        public static final int HELLO = 0;
        public static final int GOODBYE = 1;

        private String message;

        private int status;

        public String getMessage() {
            return this.message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public int getStatus() {
            return this.status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

    }

}
