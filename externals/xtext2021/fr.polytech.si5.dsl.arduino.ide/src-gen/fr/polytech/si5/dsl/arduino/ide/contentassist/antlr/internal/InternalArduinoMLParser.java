package fr.polytech.si5.dsl.arduino.ide.contentassist.antlr.internal;

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.DFA;
import fr.polytech.si5.dsl.arduino.services.ArduinoMLGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalArduinoMLParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'HIGH'", "'LOW'", "'app'", "'initial'", "'state'", "'{'", "'bricks'", "'states'", "'}'", "':'", "'Actuator'", "'Sensor'", "'<='", "'is'", "'=>'"
    };
    public static final int RULE_STRING=6;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__11=11;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int EOF=-1;
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_INT=5;
    public static final int T__22=22;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__20=20;
    public static final int T__21=21;

    // delegates
    // delegators


        public InternalArduinoMLParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalArduinoMLParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalArduinoMLParser.tokenNames; }
    public String getGrammarFileName() { return "InternalArduinoML.g"; }


    	private ArduinoMLGrammarAccess grammarAccess;

    	public void setGrammarAccess(ArduinoMLGrammarAccess grammarAccess) {
    		this.grammarAccess = grammarAccess;
    	}

    	@Override
    	protected Grammar getGrammar() {
    		return grammarAccess.getGrammar();
    	}

    	@Override
    	protected String getValueForTokenName(String tokenName) {
    		return tokenName;
    	}



    // $ANTLR start "entryRuleApp"
    // InternalArduinoML.g:53:1: entryRuleApp : ruleApp EOF ;
    public final void entryRuleApp() throws RecognitionException {
        try {
            // InternalArduinoML.g:54:1: ( ruleApp EOF )
            // InternalArduinoML.g:55:1: ruleApp EOF
            {
             before(grammarAccess.getAppRule()); 
            pushFollow(FOLLOW_1);
            ruleApp();

            state._fsp--;

             after(grammarAccess.getAppRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleApp"


    // $ANTLR start "ruleApp"
    // InternalArduinoML.g:62:1: ruleApp : ( ( rule__App__Group__0 ) ) ;
    public final void ruleApp() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArduinoML.g:66:2: ( ( ( rule__App__Group__0 ) ) )
            // InternalArduinoML.g:67:2: ( ( rule__App__Group__0 ) )
            {
            // InternalArduinoML.g:67:2: ( ( rule__App__Group__0 ) )
            // InternalArduinoML.g:68:3: ( rule__App__Group__0 )
            {
             before(grammarAccess.getAppAccess().getGroup()); 
            // InternalArduinoML.g:69:3: ( rule__App__Group__0 )
            // InternalArduinoML.g:69:4: rule__App__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__App__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getAppAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleApp"


    // $ANTLR start "entryRuleBrick"
    // InternalArduinoML.g:78:1: entryRuleBrick : ruleBrick EOF ;
    public final void entryRuleBrick() throws RecognitionException {
        try {
            // InternalArduinoML.g:79:1: ( ruleBrick EOF )
            // InternalArduinoML.g:80:1: ruleBrick EOF
            {
             before(grammarAccess.getBrickRule()); 
            pushFollow(FOLLOW_1);
            ruleBrick();

            state._fsp--;

             after(grammarAccess.getBrickRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleBrick"


    // $ANTLR start "ruleBrick"
    // InternalArduinoML.g:87:1: ruleBrick : ( ( rule__Brick__Group__0 ) ) ;
    public final void ruleBrick() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArduinoML.g:91:2: ( ( ( rule__Brick__Group__0 ) ) )
            // InternalArduinoML.g:92:2: ( ( rule__Brick__Group__0 ) )
            {
            // InternalArduinoML.g:92:2: ( ( rule__Brick__Group__0 ) )
            // InternalArduinoML.g:93:3: ( rule__Brick__Group__0 )
            {
             before(grammarAccess.getBrickAccess().getGroup()); 
            // InternalArduinoML.g:94:3: ( rule__Brick__Group__0 )
            // InternalArduinoML.g:94:4: rule__Brick__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Brick__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getBrickAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleBrick"


    // $ANTLR start "entryRuleActuator"
    // InternalArduinoML.g:103:1: entryRuleActuator : ruleActuator EOF ;
    public final void entryRuleActuator() throws RecognitionException {
        try {
            // InternalArduinoML.g:104:1: ( ruleActuator EOF )
            // InternalArduinoML.g:105:1: ruleActuator EOF
            {
             before(grammarAccess.getActuatorRule()); 
            pushFollow(FOLLOW_1);
            ruleActuator();

            state._fsp--;

             after(grammarAccess.getActuatorRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleActuator"


    // $ANTLR start "ruleActuator"
    // InternalArduinoML.g:112:1: ruleActuator : ( ( rule__Actuator__Group__0 ) ) ;
    public final void ruleActuator() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArduinoML.g:116:2: ( ( ( rule__Actuator__Group__0 ) ) )
            // InternalArduinoML.g:117:2: ( ( rule__Actuator__Group__0 ) )
            {
            // InternalArduinoML.g:117:2: ( ( rule__Actuator__Group__0 ) )
            // InternalArduinoML.g:118:3: ( rule__Actuator__Group__0 )
            {
             before(grammarAccess.getActuatorAccess().getGroup()); 
            // InternalArduinoML.g:119:3: ( rule__Actuator__Group__0 )
            // InternalArduinoML.g:119:4: rule__Actuator__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Actuator__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getActuatorAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleActuator"


    // $ANTLR start "entryRuleSensor"
    // InternalArduinoML.g:128:1: entryRuleSensor : ruleSensor EOF ;
    public final void entryRuleSensor() throws RecognitionException {
        try {
            // InternalArduinoML.g:129:1: ( ruleSensor EOF )
            // InternalArduinoML.g:130:1: ruleSensor EOF
            {
             before(grammarAccess.getSensorRule()); 
            pushFollow(FOLLOW_1);
            ruleSensor();

            state._fsp--;

             after(grammarAccess.getSensorRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleSensor"


    // $ANTLR start "ruleSensor"
    // InternalArduinoML.g:137:1: ruleSensor : ( ( rule__Sensor__Group__0 ) ) ;
    public final void ruleSensor() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArduinoML.g:141:2: ( ( ( rule__Sensor__Group__0 ) ) )
            // InternalArduinoML.g:142:2: ( ( rule__Sensor__Group__0 ) )
            {
            // InternalArduinoML.g:142:2: ( ( rule__Sensor__Group__0 ) )
            // InternalArduinoML.g:143:3: ( rule__Sensor__Group__0 )
            {
             before(grammarAccess.getSensorAccess().getGroup()); 
            // InternalArduinoML.g:144:3: ( rule__Sensor__Group__0 )
            // InternalArduinoML.g:144:4: rule__Sensor__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Sensor__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getSensorAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleSensor"


    // $ANTLR start "entryRuleState"
    // InternalArduinoML.g:153:1: entryRuleState : ruleState EOF ;
    public final void entryRuleState() throws RecognitionException {
        try {
            // InternalArduinoML.g:154:1: ( ruleState EOF )
            // InternalArduinoML.g:155:1: ruleState EOF
            {
             before(grammarAccess.getStateRule()); 
            pushFollow(FOLLOW_1);
            ruleState();

            state._fsp--;

             after(grammarAccess.getStateRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleState"


    // $ANTLR start "ruleState"
    // InternalArduinoML.g:162:1: ruleState : ( ( rule__State__Group__0 ) ) ;
    public final void ruleState() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArduinoML.g:166:2: ( ( ( rule__State__Group__0 ) ) )
            // InternalArduinoML.g:167:2: ( ( rule__State__Group__0 ) )
            {
            // InternalArduinoML.g:167:2: ( ( rule__State__Group__0 ) )
            // InternalArduinoML.g:168:3: ( rule__State__Group__0 )
            {
             before(grammarAccess.getStateAccess().getGroup()); 
            // InternalArduinoML.g:169:3: ( rule__State__Group__0 )
            // InternalArduinoML.g:169:4: rule__State__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__State__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getStateAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleState"


    // $ANTLR start "entryRuleAction"
    // InternalArduinoML.g:178:1: entryRuleAction : ruleAction EOF ;
    public final void entryRuleAction() throws RecognitionException {
        try {
            // InternalArduinoML.g:179:1: ( ruleAction EOF )
            // InternalArduinoML.g:180:1: ruleAction EOF
            {
             before(grammarAccess.getActionRule()); 
            pushFollow(FOLLOW_1);
            ruleAction();

            state._fsp--;

             after(grammarAccess.getActionRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleAction"


    // $ANTLR start "ruleAction"
    // InternalArduinoML.g:187:1: ruleAction : ( ( rule__Action__Group__0 ) ) ;
    public final void ruleAction() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArduinoML.g:191:2: ( ( ( rule__Action__Group__0 ) ) )
            // InternalArduinoML.g:192:2: ( ( rule__Action__Group__0 ) )
            {
            // InternalArduinoML.g:192:2: ( ( rule__Action__Group__0 ) )
            // InternalArduinoML.g:193:3: ( rule__Action__Group__0 )
            {
             before(grammarAccess.getActionAccess().getGroup()); 
            // InternalArduinoML.g:194:3: ( rule__Action__Group__0 )
            // InternalArduinoML.g:194:4: rule__Action__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Action__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getActionAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleAction"


    // $ANTLR start "entryRuleTransition"
    // InternalArduinoML.g:203:1: entryRuleTransition : ruleTransition EOF ;
    public final void entryRuleTransition() throws RecognitionException {
        try {
            // InternalArduinoML.g:204:1: ( ruleTransition EOF )
            // InternalArduinoML.g:205:1: ruleTransition EOF
            {
             before(grammarAccess.getTransitionRule()); 
            pushFollow(FOLLOW_1);
            ruleTransition();

            state._fsp--;

             after(grammarAccess.getTransitionRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleTransition"


    // $ANTLR start "ruleTransition"
    // InternalArduinoML.g:212:1: ruleTransition : ( ( rule__Transition__Group__0 ) ) ;
    public final void ruleTransition() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArduinoML.g:216:2: ( ( ( rule__Transition__Group__0 ) ) )
            // InternalArduinoML.g:217:2: ( ( rule__Transition__Group__0 ) )
            {
            // InternalArduinoML.g:217:2: ( ( rule__Transition__Group__0 ) )
            // InternalArduinoML.g:218:3: ( rule__Transition__Group__0 )
            {
             before(grammarAccess.getTransitionAccess().getGroup()); 
            // InternalArduinoML.g:219:3: ( rule__Transition__Group__0 )
            // InternalArduinoML.g:219:4: rule__Transition__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Transition__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getTransitionAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleTransition"


    // $ANTLR start "ruleSignal"
    // InternalArduinoML.g:228:1: ruleSignal : ( ( rule__Signal__Alternatives ) ) ;
    public final void ruleSignal() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArduinoML.g:232:1: ( ( ( rule__Signal__Alternatives ) ) )
            // InternalArduinoML.g:233:2: ( ( rule__Signal__Alternatives ) )
            {
            // InternalArduinoML.g:233:2: ( ( rule__Signal__Alternatives ) )
            // InternalArduinoML.g:234:3: ( rule__Signal__Alternatives )
            {
             before(grammarAccess.getSignalAccess().getAlternatives()); 
            // InternalArduinoML.g:235:3: ( rule__Signal__Alternatives )
            // InternalArduinoML.g:235:4: rule__Signal__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__Signal__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getSignalAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleSignal"


    // $ANTLR start "rule__Brick__Alternatives_0"
    // InternalArduinoML.g:243:1: rule__Brick__Alternatives_0 : ( ( ruleActuator ) | ( ruleSensor ) );
    public final void rule__Brick__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArduinoML.g:247:1: ( ( ruleActuator ) | ( ruleSensor ) )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==21) ) {
                alt1=1;
            }
            else if ( (LA1_0==22) ) {
                alt1=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // InternalArduinoML.g:248:2: ( ruleActuator )
                    {
                    // InternalArduinoML.g:248:2: ( ruleActuator )
                    // InternalArduinoML.g:249:3: ruleActuator
                    {
                     before(grammarAccess.getBrickAccess().getActuatorParserRuleCall_0_0()); 
                    pushFollow(FOLLOW_2);
                    ruleActuator();

                    state._fsp--;

                     after(grammarAccess.getBrickAccess().getActuatorParserRuleCall_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalArduinoML.g:254:2: ( ruleSensor )
                    {
                    // InternalArduinoML.g:254:2: ( ruleSensor )
                    // InternalArduinoML.g:255:3: ruleSensor
                    {
                     before(grammarAccess.getBrickAccess().getSensorParserRuleCall_0_1()); 
                    pushFollow(FOLLOW_2);
                    ruleSensor();

                    state._fsp--;

                     after(grammarAccess.getBrickAccess().getSensorParserRuleCall_0_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Brick__Alternatives_0"


    // $ANTLR start "rule__Signal__Alternatives"
    // InternalArduinoML.g:264:1: rule__Signal__Alternatives : ( ( ( 'HIGH' ) ) | ( ( 'LOW' ) ) );
    public final void rule__Signal__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArduinoML.g:268:1: ( ( ( 'HIGH' ) ) | ( ( 'LOW' ) ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==11) ) {
                alt2=1;
            }
            else if ( (LA2_0==12) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // InternalArduinoML.g:269:2: ( ( 'HIGH' ) )
                    {
                    // InternalArduinoML.g:269:2: ( ( 'HIGH' ) )
                    // InternalArduinoML.g:270:3: ( 'HIGH' )
                    {
                     before(grammarAccess.getSignalAccess().getHIGHEnumLiteralDeclaration_0()); 
                    // InternalArduinoML.g:271:3: ( 'HIGH' )
                    // InternalArduinoML.g:271:4: 'HIGH'
                    {
                    match(input,11,FOLLOW_2); 

                    }

                     after(grammarAccess.getSignalAccess().getHIGHEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalArduinoML.g:275:2: ( ( 'LOW' ) )
                    {
                    // InternalArduinoML.g:275:2: ( ( 'LOW' ) )
                    // InternalArduinoML.g:276:3: ( 'LOW' )
                    {
                     before(grammarAccess.getSignalAccess().getLOWEnumLiteralDeclaration_1()); 
                    // InternalArduinoML.g:277:3: ( 'LOW' )
                    // InternalArduinoML.g:277:4: 'LOW'
                    {
                    match(input,12,FOLLOW_2); 

                    }

                     after(grammarAccess.getSignalAccess().getLOWEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Signal__Alternatives"


    // $ANTLR start "rule__App__Group__0"
    // InternalArduinoML.g:285:1: rule__App__Group__0 : rule__App__Group__0__Impl rule__App__Group__1 ;
    public final void rule__App__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArduinoML.g:289:1: ( rule__App__Group__0__Impl rule__App__Group__1 )
            // InternalArduinoML.g:290:2: rule__App__Group__0__Impl rule__App__Group__1
            {
            pushFollow(FOLLOW_3);
            rule__App__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__App__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__App__Group__0"


    // $ANTLR start "rule__App__Group__0__Impl"
    // InternalArduinoML.g:297:1: rule__App__Group__0__Impl : ( 'app' ) ;
    public final void rule__App__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArduinoML.g:301:1: ( ( 'app' ) )
            // InternalArduinoML.g:302:1: ( 'app' )
            {
            // InternalArduinoML.g:302:1: ( 'app' )
            // InternalArduinoML.g:303:2: 'app'
            {
             before(grammarAccess.getAppAccess().getAppKeyword_0()); 
            match(input,13,FOLLOW_2); 
             after(grammarAccess.getAppAccess().getAppKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__App__Group__0__Impl"


    // $ANTLR start "rule__App__Group__1"
    // InternalArduinoML.g:312:1: rule__App__Group__1 : rule__App__Group__1__Impl rule__App__Group__2 ;
    public final void rule__App__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArduinoML.g:316:1: ( rule__App__Group__1__Impl rule__App__Group__2 )
            // InternalArduinoML.g:317:2: rule__App__Group__1__Impl rule__App__Group__2
            {
            pushFollow(FOLLOW_4);
            rule__App__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__App__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__App__Group__1"


    // $ANTLR start "rule__App__Group__1__Impl"
    // InternalArduinoML.g:324:1: rule__App__Group__1__Impl : ( ( rule__App__NameAssignment_1 ) ) ;
    public final void rule__App__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArduinoML.g:328:1: ( ( ( rule__App__NameAssignment_1 ) ) )
            // InternalArduinoML.g:329:1: ( ( rule__App__NameAssignment_1 ) )
            {
            // InternalArduinoML.g:329:1: ( ( rule__App__NameAssignment_1 ) )
            // InternalArduinoML.g:330:2: ( rule__App__NameAssignment_1 )
            {
             before(grammarAccess.getAppAccess().getNameAssignment_1()); 
            // InternalArduinoML.g:331:2: ( rule__App__NameAssignment_1 )
            // InternalArduinoML.g:331:3: rule__App__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__App__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getAppAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__App__Group__1__Impl"


    // $ANTLR start "rule__App__Group__2"
    // InternalArduinoML.g:339:1: rule__App__Group__2 : rule__App__Group__2__Impl rule__App__Group__3 ;
    public final void rule__App__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArduinoML.g:343:1: ( rule__App__Group__2__Impl rule__App__Group__3 )
            // InternalArduinoML.g:344:2: rule__App__Group__2__Impl rule__App__Group__3
            {
            pushFollow(FOLLOW_5);
            rule__App__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__App__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__App__Group__2"


    // $ANTLR start "rule__App__Group__2__Impl"
    // InternalArduinoML.g:351:1: rule__App__Group__2__Impl : ( 'initial' ) ;
    public final void rule__App__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArduinoML.g:355:1: ( ( 'initial' ) )
            // InternalArduinoML.g:356:1: ( 'initial' )
            {
            // InternalArduinoML.g:356:1: ( 'initial' )
            // InternalArduinoML.g:357:2: 'initial'
            {
             before(grammarAccess.getAppAccess().getInitialKeyword_2()); 
            match(input,14,FOLLOW_2); 
             after(grammarAccess.getAppAccess().getInitialKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__App__Group__2__Impl"


    // $ANTLR start "rule__App__Group__3"
    // InternalArduinoML.g:366:1: rule__App__Group__3 : rule__App__Group__3__Impl rule__App__Group__4 ;
    public final void rule__App__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArduinoML.g:370:1: ( rule__App__Group__3__Impl rule__App__Group__4 )
            // InternalArduinoML.g:371:2: rule__App__Group__3__Impl rule__App__Group__4
            {
            pushFollow(FOLLOW_3);
            rule__App__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__App__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__App__Group__3"


    // $ANTLR start "rule__App__Group__3__Impl"
    // InternalArduinoML.g:378:1: rule__App__Group__3__Impl : ( 'state' ) ;
    public final void rule__App__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArduinoML.g:382:1: ( ( 'state' ) )
            // InternalArduinoML.g:383:1: ( 'state' )
            {
            // InternalArduinoML.g:383:1: ( 'state' )
            // InternalArduinoML.g:384:2: 'state'
            {
             before(grammarAccess.getAppAccess().getStateKeyword_3()); 
            match(input,15,FOLLOW_2); 
             after(grammarAccess.getAppAccess().getStateKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__App__Group__3__Impl"


    // $ANTLR start "rule__App__Group__4"
    // InternalArduinoML.g:393:1: rule__App__Group__4 : rule__App__Group__4__Impl rule__App__Group__5 ;
    public final void rule__App__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArduinoML.g:397:1: ( rule__App__Group__4__Impl rule__App__Group__5 )
            // InternalArduinoML.g:398:2: rule__App__Group__4__Impl rule__App__Group__5
            {
            pushFollow(FOLLOW_6);
            rule__App__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__App__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__App__Group__4"


    // $ANTLR start "rule__App__Group__4__Impl"
    // InternalArduinoML.g:405:1: rule__App__Group__4__Impl : ( ( rule__App__InitialAssignment_4 ) ) ;
    public final void rule__App__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArduinoML.g:409:1: ( ( ( rule__App__InitialAssignment_4 ) ) )
            // InternalArduinoML.g:410:1: ( ( rule__App__InitialAssignment_4 ) )
            {
            // InternalArduinoML.g:410:1: ( ( rule__App__InitialAssignment_4 ) )
            // InternalArduinoML.g:411:2: ( rule__App__InitialAssignment_4 )
            {
             before(grammarAccess.getAppAccess().getInitialAssignment_4()); 
            // InternalArduinoML.g:412:2: ( rule__App__InitialAssignment_4 )
            // InternalArduinoML.g:412:3: rule__App__InitialAssignment_4
            {
            pushFollow(FOLLOW_2);
            rule__App__InitialAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getAppAccess().getInitialAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__App__Group__4__Impl"


    // $ANTLR start "rule__App__Group__5"
    // InternalArduinoML.g:420:1: rule__App__Group__5 : rule__App__Group__5__Impl rule__App__Group__6 ;
    public final void rule__App__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArduinoML.g:424:1: ( rule__App__Group__5__Impl rule__App__Group__6 )
            // InternalArduinoML.g:425:2: rule__App__Group__5__Impl rule__App__Group__6
            {
            pushFollow(FOLLOW_7);
            rule__App__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__App__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__App__Group__5"


    // $ANTLR start "rule__App__Group__5__Impl"
    // InternalArduinoML.g:432:1: rule__App__Group__5__Impl : ( '{' ) ;
    public final void rule__App__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArduinoML.g:436:1: ( ( '{' ) )
            // InternalArduinoML.g:437:1: ( '{' )
            {
            // InternalArduinoML.g:437:1: ( '{' )
            // InternalArduinoML.g:438:2: '{'
            {
             before(grammarAccess.getAppAccess().getLeftCurlyBracketKeyword_5()); 
            match(input,16,FOLLOW_2); 
             after(grammarAccess.getAppAccess().getLeftCurlyBracketKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__App__Group__5__Impl"


    // $ANTLR start "rule__App__Group__6"
    // InternalArduinoML.g:447:1: rule__App__Group__6 : rule__App__Group__6__Impl rule__App__Group__7 ;
    public final void rule__App__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArduinoML.g:451:1: ( rule__App__Group__6__Impl rule__App__Group__7 )
            // InternalArduinoML.g:452:2: rule__App__Group__6__Impl rule__App__Group__7
            {
            pushFollow(FOLLOW_8);
            rule__App__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__App__Group__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__App__Group__6"


    // $ANTLR start "rule__App__Group__6__Impl"
    // InternalArduinoML.g:459:1: rule__App__Group__6__Impl : ( 'bricks' ) ;
    public final void rule__App__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArduinoML.g:463:1: ( ( 'bricks' ) )
            // InternalArduinoML.g:464:1: ( 'bricks' )
            {
            // InternalArduinoML.g:464:1: ( 'bricks' )
            // InternalArduinoML.g:465:2: 'bricks'
            {
             before(grammarAccess.getAppAccess().getBricksKeyword_6()); 
            match(input,17,FOLLOW_2); 
             after(grammarAccess.getAppAccess().getBricksKeyword_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__App__Group__6__Impl"


    // $ANTLR start "rule__App__Group__7"
    // InternalArduinoML.g:474:1: rule__App__Group__7 : rule__App__Group__7__Impl rule__App__Group__8 ;
    public final void rule__App__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArduinoML.g:478:1: ( rule__App__Group__7__Impl rule__App__Group__8 )
            // InternalArduinoML.g:479:2: rule__App__Group__7__Impl rule__App__Group__8
            {
            pushFollow(FOLLOW_9);
            rule__App__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__App__Group__8();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__App__Group__7"


    // $ANTLR start "rule__App__Group__7__Impl"
    // InternalArduinoML.g:486:1: rule__App__Group__7__Impl : ( ( rule__App__BricksAssignment_7 ) ) ;
    public final void rule__App__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArduinoML.g:490:1: ( ( ( rule__App__BricksAssignment_7 ) ) )
            // InternalArduinoML.g:491:1: ( ( rule__App__BricksAssignment_7 ) )
            {
            // InternalArduinoML.g:491:1: ( ( rule__App__BricksAssignment_7 ) )
            // InternalArduinoML.g:492:2: ( rule__App__BricksAssignment_7 )
            {
             before(grammarAccess.getAppAccess().getBricksAssignment_7()); 
            // InternalArduinoML.g:493:2: ( rule__App__BricksAssignment_7 )
            // InternalArduinoML.g:493:3: rule__App__BricksAssignment_7
            {
            pushFollow(FOLLOW_2);
            rule__App__BricksAssignment_7();

            state._fsp--;


            }

             after(grammarAccess.getAppAccess().getBricksAssignment_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__App__Group__7__Impl"


    // $ANTLR start "rule__App__Group__8"
    // InternalArduinoML.g:501:1: rule__App__Group__8 : rule__App__Group__8__Impl rule__App__Group__9 ;
    public final void rule__App__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArduinoML.g:505:1: ( rule__App__Group__8__Impl rule__App__Group__9 )
            // InternalArduinoML.g:506:2: rule__App__Group__8__Impl rule__App__Group__9
            {
            pushFollow(FOLLOW_9);
            rule__App__Group__8__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__App__Group__9();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__App__Group__8"


    // $ANTLR start "rule__App__Group__8__Impl"
    // InternalArduinoML.g:513:1: rule__App__Group__8__Impl : ( ( rule__App__BricksAssignment_8 )* ) ;
    public final void rule__App__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArduinoML.g:517:1: ( ( ( rule__App__BricksAssignment_8 )* ) )
            // InternalArduinoML.g:518:1: ( ( rule__App__BricksAssignment_8 )* )
            {
            // InternalArduinoML.g:518:1: ( ( rule__App__BricksAssignment_8 )* )
            // InternalArduinoML.g:519:2: ( rule__App__BricksAssignment_8 )*
            {
             before(grammarAccess.getAppAccess().getBricksAssignment_8()); 
            // InternalArduinoML.g:520:2: ( rule__App__BricksAssignment_8 )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>=21 && LA3_0<=22)) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalArduinoML.g:520:3: rule__App__BricksAssignment_8
            	    {
            	    pushFollow(FOLLOW_10);
            	    rule__App__BricksAssignment_8();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

             after(grammarAccess.getAppAccess().getBricksAssignment_8()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__App__Group__8__Impl"


    // $ANTLR start "rule__App__Group__9"
    // InternalArduinoML.g:528:1: rule__App__Group__9 : rule__App__Group__9__Impl rule__App__Group__10 ;
    public final void rule__App__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArduinoML.g:532:1: ( rule__App__Group__9__Impl rule__App__Group__10 )
            // InternalArduinoML.g:533:2: rule__App__Group__9__Impl rule__App__Group__10
            {
            pushFollow(FOLLOW_3);
            rule__App__Group__9__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__App__Group__10();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__App__Group__9"


    // $ANTLR start "rule__App__Group__9__Impl"
    // InternalArduinoML.g:540:1: rule__App__Group__9__Impl : ( 'states' ) ;
    public final void rule__App__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArduinoML.g:544:1: ( ( 'states' ) )
            // InternalArduinoML.g:545:1: ( 'states' )
            {
            // InternalArduinoML.g:545:1: ( 'states' )
            // InternalArduinoML.g:546:2: 'states'
            {
             before(grammarAccess.getAppAccess().getStatesKeyword_9()); 
            match(input,18,FOLLOW_2); 
             after(grammarAccess.getAppAccess().getStatesKeyword_9()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__App__Group__9__Impl"


    // $ANTLR start "rule__App__Group__10"
    // InternalArduinoML.g:555:1: rule__App__Group__10 : rule__App__Group__10__Impl rule__App__Group__11 ;
    public final void rule__App__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArduinoML.g:559:1: ( rule__App__Group__10__Impl rule__App__Group__11 )
            // InternalArduinoML.g:560:2: rule__App__Group__10__Impl rule__App__Group__11
            {
            pushFollow(FOLLOW_11);
            rule__App__Group__10__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__App__Group__11();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__App__Group__10"


    // $ANTLR start "rule__App__Group__10__Impl"
    // InternalArduinoML.g:567:1: rule__App__Group__10__Impl : ( ( rule__App__StatesAssignment_10 ) ) ;
    public final void rule__App__Group__10__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArduinoML.g:571:1: ( ( ( rule__App__StatesAssignment_10 ) ) )
            // InternalArduinoML.g:572:1: ( ( rule__App__StatesAssignment_10 ) )
            {
            // InternalArduinoML.g:572:1: ( ( rule__App__StatesAssignment_10 ) )
            // InternalArduinoML.g:573:2: ( rule__App__StatesAssignment_10 )
            {
             before(grammarAccess.getAppAccess().getStatesAssignment_10()); 
            // InternalArduinoML.g:574:2: ( rule__App__StatesAssignment_10 )
            // InternalArduinoML.g:574:3: rule__App__StatesAssignment_10
            {
            pushFollow(FOLLOW_2);
            rule__App__StatesAssignment_10();

            state._fsp--;


            }

             after(grammarAccess.getAppAccess().getStatesAssignment_10()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__App__Group__10__Impl"


    // $ANTLR start "rule__App__Group__11"
    // InternalArduinoML.g:582:1: rule__App__Group__11 : rule__App__Group__11__Impl rule__App__Group__12 ;
    public final void rule__App__Group__11() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArduinoML.g:586:1: ( rule__App__Group__11__Impl rule__App__Group__12 )
            // InternalArduinoML.g:587:2: rule__App__Group__11__Impl rule__App__Group__12
            {
            pushFollow(FOLLOW_11);
            rule__App__Group__11__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__App__Group__12();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__App__Group__11"


    // $ANTLR start "rule__App__Group__11__Impl"
    // InternalArduinoML.g:594:1: rule__App__Group__11__Impl : ( ( rule__App__StatesAssignment_11 )* ) ;
    public final void rule__App__Group__11__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArduinoML.g:598:1: ( ( ( rule__App__StatesAssignment_11 )* ) )
            // InternalArduinoML.g:599:1: ( ( rule__App__StatesAssignment_11 )* )
            {
            // InternalArduinoML.g:599:1: ( ( rule__App__StatesAssignment_11 )* )
            // InternalArduinoML.g:600:2: ( rule__App__StatesAssignment_11 )*
            {
             before(grammarAccess.getAppAccess().getStatesAssignment_11()); 
            // InternalArduinoML.g:601:2: ( rule__App__StatesAssignment_11 )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==RULE_ID) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // InternalArduinoML.g:601:3: rule__App__StatesAssignment_11
            	    {
            	    pushFollow(FOLLOW_12);
            	    rule__App__StatesAssignment_11();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

             after(grammarAccess.getAppAccess().getStatesAssignment_11()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__App__Group__11__Impl"


    // $ANTLR start "rule__App__Group__12"
    // InternalArduinoML.g:609:1: rule__App__Group__12 : rule__App__Group__12__Impl ;
    public final void rule__App__Group__12() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArduinoML.g:613:1: ( rule__App__Group__12__Impl )
            // InternalArduinoML.g:614:2: rule__App__Group__12__Impl
            {
            pushFollow(FOLLOW_2);
            rule__App__Group__12__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__App__Group__12"


    // $ANTLR start "rule__App__Group__12__Impl"
    // InternalArduinoML.g:620:1: rule__App__Group__12__Impl : ( '}' ) ;
    public final void rule__App__Group__12__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArduinoML.g:624:1: ( ( '}' ) )
            // InternalArduinoML.g:625:1: ( '}' )
            {
            // InternalArduinoML.g:625:1: ( '}' )
            // InternalArduinoML.g:626:2: '}'
            {
             before(grammarAccess.getAppAccess().getRightCurlyBracketKeyword_12()); 
            match(input,19,FOLLOW_2); 
             after(grammarAccess.getAppAccess().getRightCurlyBracketKeyword_12()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__App__Group__12__Impl"


    // $ANTLR start "rule__Brick__Group__0"
    // InternalArduinoML.g:636:1: rule__Brick__Group__0 : rule__Brick__Group__0__Impl rule__Brick__Group__1 ;
    public final void rule__Brick__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArduinoML.g:640:1: ( rule__Brick__Group__0__Impl rule__Brick__Group__1 )
            // InternalArduinoML.g:641:2: rule__Brick__Group__0__Impl rule__Brick__Group__1
            {
            pushFollow(FOLLOW_3);
            rule__Brick__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Brick__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Brick__Group__0"


    // $ANTLR start "rule__Brick__Group__0__Impl"
    // InternalArduinoML.g:648:1: rule__Brick__Group__0__Impl : ( ( rule__Brick__Alternatives_0 ) ) ;
    public final void rule__Brick__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArduinoML.g:652:1: ( ( ( rule__Brick__Alternatives_0 ) ) )
            // InternalArduinoML.g:653:1: ( ( rule__Brick__Alternatives_0 ) )
            {
            // InternalArduinoML.g:653:1: ( ( rule__Brick__Alternatives_0 ) )
            // InternalArduinoML.g:654:2: ( rule__Brick__Alternatives_0 )
            {
             before(grammarAccess.getBrickAccess().getAlternatives_0()); 
            // InternalArduinoML.g:655:2: ( rule__Brick__Alternatives_0 )
            // InternalArduinoML.g:655:3: rule__Brick__Alternatives_0
            {
            pushFollow(FOLLOW_2);
            rule__Brick__Alternatives_0();

            state._fsp--;


            }

             after(grammarAccess.getBrickAccess().getAlternatives_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Brick__Group__0__Impl"


    // $ANTLR start "rule__Brick__Group__1"
    // InternalArduinoML.g:663:1: rule__Brick__Group__1 : rule__Brick__Group__1__Impl rule__Brick__Group__2 ;
    public final void rule__Brick__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArduinoML.g:667:1: ( rule__Brick__Group__1__Impl rule__Brick__Group__2 )
            // InternalArduinoML.g:668:2: rule__Brick__Group__1__Impl rule__Brick__Group__2
            {
            pushFollow(FOLLOW_13);
            rule__Brick__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Brick__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Brick__Group__1"


    // $ANTLR start "rule__Brick__Group__1__Impl"
    // InternalArduinoML.g:675:1: rule__Brick__Group__1__Impl : ( ( rule__Brick__NameAssignment_1 ) ) ;
    public final void rule__Brick__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArduinoML.g:679:1: ( ( ( rule__Brick__NameAssignment_1 ) ) )
            // InternalArduinoML.g:680:1: ( ( rule__Brick__NameAssignment_1 ) )
            {
            // InternalArduinoML.g:680:1: ( ( rule__Brick__NameAssignment_1 ) )
            // InternalArduinoML.g:681:2: ( rule__Brick__NameAssignment_1 )
            {
             before(grammarAccess.getBrickAccess().getNameAssignment_1()); 
            // InternalArduinoML.g:682:2: ( rule__Brick__NameAssignment_1 )
            // InternalArduinoML.g:682:3: rule__Brick__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__Brick__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getBrickAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Brick__Group__1__Impl"


    // $ANTLR start "rule__Brick__Group__2"
    // InternalArduinoML.g:690:1: rule__Brick__Group__2 : rule__Brick__Group__2__Impl rule__Brick__Group__3 ;
    public final void rule__Brick__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArduinoML.g:694:1: ( rule__Brick__Group__2__Impl rule__Brick__Group__3 )
            // InternalArduinoML.g:695:2: rule__Brick__Group__2__Impl rule__Brick__Group__3
            {
            pushFollow(FOLLOW_14);
            rule__Brick__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Brick__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Brick__Group__2"


    // $ANTLR start "rule__Brick__Group__2__Impl"
    // InternalArduinoML.g:702:1: rule__Brick__Group__2__Impl : ( ':' ) ;
    public final void rule__Brick__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArduinoML.g:706:1: ( ( ':' ) )
            // InternalArduinoML.g:707:1: ( ':' )
            {
            // InternalArduinoML.g:707:1: ( ':' )
            // InternalArduinoML.g:708:2: ':'
            {
             before(grammarAccess.getBrickAccess().getColonKeyword_2()); 
            match(input,20,FOLLOW_2); 
             after(grammarAccess.getBrickAccess().getColonKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Brick__Group__2__Impl"


    // $ANTLR start "rule__Brick__Group__3"
    // InternalArduinoML.g:717:1: rule__Brick__Group__3 : rule__Brick__Group__3__Impl ;
    public final void rule__Brick__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArduinoML.g:721:1: ( rule__Brick__Group__3__Impl )
            // InternalArduinoML.g:722:2: rule__Brick__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Brick__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Brick__Group__3"


    // $ANTLR start "rule__Brick__Group__3__Impl"
    // InternalArduinoML.g:728:1: rule__Brick__Group__3__Impl : ( ( rule__Brick__PinAssignment_3 ) ) ;
    public final void rule__Brick__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArduinoML.g:732:1: ( ( ( rule__Brick__PinAssignment_3 ) ) )
            // InternalArduinoML.g:733:1: ( ( rule__Brick__PinAssignment_3 ) )
            {
            // InternalArduinoML.g:733:1: ( ( rule__Brick__PinAssignment_3 ) )
            // InternalArduinoML.g:734:2: ( rule__Brick__PinAssignment_3 )
            {
             before(grammarAccess.getBrickAccess().getPinAssignment_3()); 
            // InternalArduinoML.g:735:2: ( rule__Brick__PinAssignment_3 )
            // InternalArduinoML.g:735:3: rule__Brick__PinAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__Brick__PinAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getBrickAccess().getPinAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Brick__Group__3__Impl"


    // $ANTLR start "rule__Actuator__Group__0"
    // InternalArduinoML.g:744:1: rule__Actuator__Group__0 : rule__Actuator__Group__0__Impl rule__Actuator__Group__1 ;
    public final void rule__Actuator__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArduinoML.g:748:1: ( rule__Actuator__Group__0__Impl rule__Actuator__Group__1 )
            // InternalArduinoML.g:749:2: rule__Actuator__Group__0__Impl rule__Actuator__Group__1
            {
            pushFollow(FOLLOW_15);
            rule__Actuator__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Actuator__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Actuator__Group__0"


    // $ANTLR start "rule__Actuator__Group__0__Impl"
    // InternalArduinoML.g:756:1: rule__Actuator__Group__0__Impl : ( () ) ;
    public final void rule__Actuator__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArduinoML.g:760:1: ( ( () ) )
            // InternalArduinoML.g:761:1: ( () )
            {
            // InternalArduinoML.g:761:1: ( () )
            // InternalArduinoML.g:762:2: ()
            {
             before(grammarAccess.getActuatorAccess().getActuatorAction_0()); 
            // InternalArduinoML.g:763:2: ()
            // InternalArduinoML.g:763:3: 
            {
            }

             after(grammarAccess.getActuatorAccess().getActuatorAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Actuator__Group__0__Impl"


    // $ANTLR start "rule__Actuator__Group__1"
    // InternalArduinoML.g:771:1: rule__Actuator__Group__1 : rule__Actuator__Group__1__Impl ;
    public final void rule__Actuator__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArduinoML.g:775:1: ( rule__Actuator__Group__1__Impl )
            // InternalArduinoML.g:776:2: rule__Actuator__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Actuator__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Actuator__Group__1"


    // $ANTLR start "rule__Actuator__Group__1__Impl"
    // InternalArduinoML.g:782:1: rule__Actuator__Group__1__Impl : ( 'Actuator' ) ;
    public final void rule__Actuator__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArduinoML.g:786:1: ( ( 'Actuator' ) )
            // InternalArduinoML.g:787:1: ( 'Actuator' )
            {
            // InternalArduinoML.g:787:1: ( 'Actuator' )
            // InternalArduinoML.g:788:2: 'Actuator'
            {
             before(grammarAccess.getActuatorAccess().getActuatorKeyword_1()); 
            match(input,21,FOLLOW_2); 
             after(grammarAccess.getActuatorAccess().getActuatorKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Actuator__Group__1__Impl"


    // $ANTLR start "rule__Sensor__Group__0"
    // InternalArduinoML.g:798:1: rule__Sensor__Group__0 : rule__Sensor__Group__0__Impl rule__Sensor__Group__1 ;
    public final void rule__Sensor__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArduinoML.g:802:1: ( rule__Sensor__Group__0__Impl rule__Sensor__Group__1 )
            // InternalArduinoML.g:803:2: rule__Sensor__Group__0__Impl rule__Sensor__Group__1
            {
            pushFollow(FOLLOW_8);
            rule__Sensor__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Sensor__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sensor__Group__0"


    // $ANTLR start "rule__Sensor__Group__0__Impl"
    // InternalArduinoML.g:810:1: rule__Sensor__Group__0__Impl : ( () ) ;
    public final void rule__Sensor__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArduinoML.g:814:1: ( ( () ) )
            // InternalArduinoML.g:815:1: ( () )
            {
            // InternalArduinoML.g:815:1: ( () )
            // InternalArduinoML.g:816:2: ()
            {
             before(grammarAccess.getSensorAccess().getSensorAction_0()); 
            // InternalArduinoML.g:817:2: ()
            // InternalArduinoML.g:817:3: 
            {
            }

             after(grammarAccess.getSensorAccess().getSensorAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sensor__Group__0__Impl"


    // $ANTLR start "rule__Sensor__Group__1"
    // InternalArduinoML.g:825:1: rule__Sensor__Group__1 : rule__Sensor__Group__1__Impl ;
    public final void rule__Sensor__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArduinoML.g:829:1: ( rule__Sensor__Group__1__Impl )
            // InternalArduinoML.g:830:2: rule__Sensor__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Sensor__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sensor__Group__1"


    // $ANTLR start "rule__Sensor__Group__1__Impl"
    // InternalArduinoML.g:836:1: rule__Sensor__Group__1__Impl : ( 'Sensor' ) ;
    public final void rule__Sensor__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArduinoML.g:840:1: ( ( 'Sensor' ) )
            // InternalArduinoML.g:841:1: ( 'Sensor' )
            {
            // InternalArduinoML.g:841:1: ( 'Sensor' )
            // InternalArduinoML.g:842:2: 'Sensor'
            {
             before(grammarAccess.getSensorAccess().getSensorKeyword_1()); 
            match(input,22,FOLLOW_2); 
             after(grammarAccess.getSensorAccess().getSensorKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sensor__Group__1__Impl"


    // $ANTLR start "rule__State__Group__0"
    // InternalArduinoML.g:852:1: rule__State__Group__0 : rule__State__Group__0__Impl rule__State__Group__1 ;
    public final void rule__State__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArduinoML.g:856:1: ( rule__State__Group__0__Impl rule__State__Group__1 )
            // InternalArduinoML.g:857:2: rule__State__Group__0__Impl rule__State__Group__1
            {
            pushFollow(FOLLOW_6);
            rule__State__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__State__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__State__Group__0"


    // $ANTLR start "rule__State__Group__0__Impl"
    // InternalArduinoML.g:864:1: rule__State__Group__0__Impl : ( ( rule__State__NameAssignment_0 ) ) ;
    public final void rule__State__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArduinoML.g:868:1: ( ( ( rule__State__NameAssignment_0 ) ) )
            // InternalArduinoML.g:869:1: ( ( rule__State__NameAssignment_0 ) )
            {
            // InternalArduinoML.g:869:1: ( ( rule__State__NameAssignment_0 ) )
            // InternalArduinoML.g:870:2: ( rule__State__NameAssignment_0 )
            {
             before(grammarAccess.getStateAccess().getNameAssignment_0()); 
            // InternalArduinoML.g:871:2: ( rule__State__NameAssignment_0 )
            // InternalArduinoML.g:871:3: rule__State__NameAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__State__NameAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getStateAccess().getNameAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__State__Group__0__Impl"


    // $ANTLR start "rule__State__Group__1"
    // InternalArduinoML.g:879:1: rule__State__Group__1 : rule__State__Group__1__Impl rule__State__Group__2 ;
    public final void rule__State__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArduinoML.g:883:1: ( rule__State__Group__1__Impl rule__State__Group__2 )
            // InternalArduinoML.g:884:2: rule__State__Group__1__Impl rule__State__Group__2
            {
            pushFollow(FOLLOW_3);
            rule__State__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__State__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__State__Group__1"


    // $ANTLR start "rule__State__Group__1__Impl"
    // InternalArduinoML.g:891:1: rule__State__Group__1__Impl : ( '{' ) ;
    public final void rule__State__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArduinoML.g:895:1: ( ( '{' ) )
            // InternalArduinoML.g:896:1: ( '{' )
            {
            // InternalArduinoML.g:896:1: ( '{' )
            // InternalArduinoML.g:897:2: '{'
            {
             before(grammarAccess.getStateAccess().getLeftCurlyBracketKeyword_1()); 
            match(input,16,FOLLOW_2); 
             after(grammarAccess.getStateAccess().getLeftCurlyBracketKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__State__Group__1__Impl"


    // $ANTLR start "rule__State__Group__2"
    // InternalArduinoML.g:906:1: rule__State__Group__2 : rule__State__Group__2__Impl rule__State__Group__3 ;
    public final void rule__State__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArduinoML.g:910:1: ( rule__State__Group__2__Impl rule__State__Group__3 )
            // InternalArduinoML.g:911:2: rule__State__Group__2__Impl rule__State__Group__3
            {
            pushFollow(FOLLOW_3);
            rule__State__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__State__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__State__Group__2"


    // $ANTLR start "rule__State__Group__2__Impl"
    // InternalArduinoML.g:918:1: rule__State__Group__2__Impl : ( ( rule__State__ActionsAssignment_2 ) ) ;
    public final void rule__State__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArduinoML.g:922:1: ( ( ( rule__State__ActionsAssignment_2 ) ) )
            // InternalArduinoML.g:923:1: ( ( rule__State__ActionsAssignment_2 ) )
            {
            // InternalArduinoML.g:923:1: ( ( rule__State__ActionsAssignment_2 ) )
            // InternalArduinoML.g:924:2: ( rule__State__ActionsAssignment_2 )
            {
             before(grammarAccess.getStateAccess().getActionsAssignment_2()); 
            // InternalArduinoML.g:925:2: ( rule__State__ActionsAssignment_2 )
            // InternalArduinoML.g:925:3: rule__State__ActionsAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__State__ActionsAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getStateAccess().getActionsAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__State__Group__2__Impl"


    // $ANTLR start "rule__State__Group__3"
    // InternalArduinoML.g:933:1: rule__State__Group__3 : rule__State__Group__3__Impl rule__State__Group__4 ;
    public final void rule__State__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArduinoML.g:937:1: ( rule__State__Group__3__Impl rule__State__Group__4 )
            // InternalArduinoML.g:938:2: rule__State__Group__3__Impl rule__State__Group__4
            {
            pushFollow(FOLLOW_3);
            rule__State__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__State__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__State__Group__3"


    // $ANTLR start "rule__State__Group__3__Impl"
    // InternalArduinoML.g:945:1: rule__State__Group__3__Impl : ( ( rule__State__ActionsAssignment_3 )* ) ;
    public final void rule__State__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArduinoML.g:949:1: ( ( ( rule__State__ActionsAssignment_3 )* ) )
            // InternalArduinoML.g:950:1: ( ( rule__State__ActionsAssignment_3 )* )
            {
            // InternalArduinoML.g:950:1: ( ( rule__State__ActionsAssignment_3 )* )
            // InternalArduinoML.g:951:2: ( rule__State__ActionsAssignment_3 )*
            {
             before(grammarAccess.getStateAccess().getActionsAssignment_3()); 
            // InternalArduinoML.g:952:2: ( rule__State__ActionsAssignment_3 )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==RULE_ID) ) {
                    int LA5_1 = input.LA(2);

                    if ( (LA5_1==23) ) {
                        alt5=1;
                    }


                }


                switch (alt5) {
            	case 1 :
            	    // InternalArduinoML.g:952:3: rule__State__ActionsAssignment_3
            	    {
            	    pushFollow(FOLLOW_12);
            	    rule__State__ActionsAssignment_3();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

             after(grammarAccess.getStateAccess().getActionsAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__State__Group__3__Impl"


    // $ANTLR start "rule__State__Group__4"
    // InternalArduinoML.g:960:1: rule__State__Group__4 : rule__State__Group__4__Impl rule__State__Group__5 ;
    public final void rule__State__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArduinoML.g:964:1: ( rule__State__Group__4__Impl rule__State__Group__5 )
            // InternalArduinoML.g:965:2: rule__State__Group__4__Impl rule__State__Group__5
            {
            pushFollow(FOLLOW_16);
            rule__State__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__State__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__State__Group__4"


    // $ANTLR start "rule__State__Group__4__Impl"
    // InternalArduinoML.g:972:1: rule__State__Group__4__Impl : ( ( rule__State__TransitionAssignment_4 ) ) ;
    public final void rule__State__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArduinoML.g:976:1: ( ( ( rule__State__TransitionAssignment_4 ) ) )
            // InternalArduinoML.g:977:1: ( ( rule__State__TransitionAssignment_4 ) )
            {
            // InternalArduinoML.g:977:1: ( ( rule__State__TransitionAssignment_4 ) )
            // InternalArduinoML.g:978:2: ( rule__State__TransitionAssignment_4 )
            {
             before(grammarAccess.getStateAccess().getTransitionAssignment_4()); 
            // InternalArduinoML.g:979:2: ( rule__State__TransitionAssignment_4 )
            // InternalArduinoML.g:979:3: rule__State__TransitionAssignment_4
            {
            pushFollow(FOLLOW_2);
            rule__State__TransitionAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getStateAccess().getTransitionAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__State__Group__4__Impl"


    // $ANTLR start "rule__State__Group__5"
    // InternalArduinoML.g:987:1: rule__State__Group__5 : rule__State__Group__5__Impl ;
    public final void rule__State__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArduinoML.g:991:1: ( rule__State__Group__5__Impl )
            // InternalArduinoML.g:992:2: rule__State__Group__5__Impl
            {
            pushFollow(FOLLOW_2);
            rule__State__Group__5__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__State__Group__5"


    // $ANTLR start "rule__State__Group__5__Impl"
    // InternalArduinoML.g:998:1: rule__State__Group__5__Impl : ( '}' ) ;
    public final void rule__State__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArduinoML.g:1002:1: ( ( '}' ) )
            // InternalArduinoML.g:1003:1: ( '}' )
            {
            // InternalArduinoML.g:1003:1: ( '}' )
            // InternalArduinoML.g:1004:2: '}'
            {
             before(grammarAccess.getStateAccess().getRightCurlyBracketKeyword_5()); 
            match(input,19,FOLLOW_2); 
             after(grammarAccess.getStateAccess().getRightCurlyBracketKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__State__Group__5__Impl"


    // $ANTLR start "rule__Action__Group__0"
    // InternalArduinoML.g:1014:1: rule__Action__Group__0 : rule__Action__Group__0__Impl rule__Action__Group__1 ;
    public final void rule__Action__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArduinoML.g:1018:1: ( rule__Action__Group__0__Impl rule__Action__Group__1 )
            // InternalArduinoML.g:1019:2: rule__Action__Group__0__Impl rule__Action__Group__1
            {
            pushFollow(FOLLOW_17);
            rule__Action__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Action__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Action__Group__0"


    // $ANTLR start "rule__Action__Group__0__Impl"
    // InternalArduinoML.g:1026:1: rule__Action__Group__0__Impl : ( ( rule__Action__ActuatorAssignment_0 ) ) ;
    public final void rule__Action__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArduinoML.g:1030:1: ( ( ( rule__Action__ActuatorAssignment_0 ) ) )
            // InternalArduinoML.g:1031:1: ( ( rule__Action__ActuatorAssignment_0 ) )
            {
            // InternalArduinoML.g:1031:1: ( ( rule__Action__ActuatorAssignment_0 ) )
            // InternalArduinoML.g:1032:2: ( rule__Action__ActuatorAssignment_0 )
            {
             before(grammarAccess.getActionAccess().getActuatorAssignment_0()); 
            // InternalArduinoML.g:1033:2: ( rule__Action__ActuatorAssignment_0 )
            // InternalArduinoML.g:1033:3: rule__Action__ActuatorAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__Action__ActuatorAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getActionAccess().getActuatorAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Action__Group__0__Impl"


    // $ANTLR start "rule__Action__Group__1"
    // InternalArduinoML.g:1041:1: rule__Action__Group__1 : rule__Action__Group__1__Impl rule__Action__Group__2 ;
    public final void rule__Action__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArduinoML.g:1045:1: ( rule__Action__Group__1__Impl rule__Action__Group__2 )
            // InternalArduinoML.g:1046:2: rule__Action__Group__1__Impl rule__Action__Group__2
            {
            pushFollow(FOLLOW_18);
            rule__Action__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Action__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Action__Group__1"


    // $ANTLR start "rule__Action__Group__1__Impl"
    // InternalArduinoML.g:1053:1: rule__Action__Group__1__Impl : ( '<=' ) ;
    public final void rule__Action__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArduinoML.g:1057:1: ( ( '<=' ) )
            // InternalArduinoML.g:1058:1: ( '<=' )
            {
            // InternalArduinoML.g:1058:1: ( '<=' )
            // InternalArduinoML.g:1059:2: '<='
            {
             before(grammarAccess.getActionAccess().getLessThanSignEqualsSignKeyword_1()); 
            match(input,23,FOLLOW_2); 
             after(grammarAccess.getActionAccess().getLessThanSignEqualsSignKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Action__Group__1__Impl"


    // $ANTLR start "rule__Action__Group__2"
    // InternalArduinoML.g:1068:1: rule__Action__Group__2 : rule__Action__Group__2__Impl ;
    public final void rule__Action__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArduinoML.g:1072:1: ( rule__Action__Group__2__Impl )
            // InternalArduinoML.g:1073:2: rule__Action__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Action__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Action__Group__2"


    // $ANTLR start "rule__Action__Group__2__Impl"
    // InternalArduinoML.g:1079:1: rule__Action__Group__2__Impl : ( ( rule__Action__ValueAssignment_2 ) ) ;
    public final void rule__Action__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArduinoML.g:1083:1: ( ( ( rule__Action__ValueAssignment_2 ) ) )
            // InternalArduinoML.g:1084:1: ( ( rule__Action__ValueAssignment_2 ) )
            {
            // InternalArduinoML.g:1084:1: ( ( rule__Action__ValueAssignment_2 ) )
            // InternalArduinoML.g:1085:2: ( rule__Action__ValueAssignment_2 )
            {
             before(grammarAccess.getActionAccess().getValueAssignment_2()); 
            // InternalArduinoML.g:1086:2: ( rule__Action__ValueAssignment_2 )
            // InternalArduinoML.g:1086:3: rule__Action__ValueAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__Action__ValueAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getActionAccess().getValueAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Action__Group__2__Impl"


    // $ANTLR start "rule__Transition__Group__0"
    // InternalArduinoML.g:1095:1: rule__Transition__Group__0 : rule__Transition__Group__0__Impl rule__Transition__Group__1 ;
    public final void rule__Transition__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArduinoML.g:1099:1: ( rule__Transition__Group__0__Impl rule__Transition__Group__1 )
            // InternalArduinoML.g:1100:2: rule__Transition__Group__0__Impl rule__Transition__Group__1
            {
            pushFollow(FOLLOW_19);
            rule__Transition__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Transition__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Transition__Group__0"


    // $ANTLR start "rule__Transition__Group__0__Impl"
    // InternalArduinoML.g:1107:1: rule__Transition__Group__0__Impl : ( ( rule__Transition__SensorAssignment_0 ) ) ;
    public final void rule__Transition__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArduinoML.g:1111:1: ( ( ( rule__Transition__SensorAssignment_0 ) ) )
            // InternalArduinoML.g:1112:1: ( ( rule__Transition__SensorAssignment_0 ) )
            {
            // InternalArduinoML.g:1112:1: ( ( rule__Transition__SensorAssignment_0 ) )
            // InternalArduinoML.g:1113:2: ( rule__Transition__SensorAssignment_0 )
            {
             before(grammarAccess.getTransitionAccess().getSensorAssignment_0()); 
            // InternalArduinoML.g:1114:2: ( rule__Transition__SensorAssignment_0 )
            // InternalArduinoML.g:1114:3: rule__Transition__SensorAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__Transition__SensorAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getTransitionAccess().getSensorAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Transition__Group__0__Impl"


    // $ANTLR start "rule__Transition__Group__1"
    // InternalArduinoML.g:1122:1: rule__Transition__Group__1 : rule__Transition__Group__1__Impl rule__Transition__Group__2 ;
    public final void rule__Transition__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArduinoML.g:1126:1: ( rule__Transition__Group__1__Impl rule__Transition__Group__2 )
            // InternalArduinoML.g:1127:2: rule__Transition__Group__1__Impl rule__Transition__Group__2
            {
            pushFollow(FOLLOW_18);
            rule__Transition__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Transition__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Transition__Group__1"


    // $ANTLR start "rule__Transition__Group__1__Impl"
    // InternalArduinoML.g:1134:1: rule__Transition__Group__1__Impl : ( 'is' ) ;
    public final void rule__Transition__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArduinoML.g:1138:1: ( ( 'is' ) )
            // InternalArduinoML.g:1139:1: ( 'is' )
            {
            // InternalArduinoML.g:1139:1: ( 'is' )
            // InternalArduinoML.g:1140:2: 'is'
            {
             before(grammarAccess.getTransitionAccess().getIsKeyword_1()); 
            match(input,24,FOLLOW_2); 
             after(grammarAccess.getTransitionAccess().getIsKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Transition__Group__1__Impl"


    // $ANTLR start "rule__Transition__Group__2"
    // InternalArduinoML.g:1149:1: rule__Transition__Group__2 : rule__Transition__Group__2__Impl rule__Transition__Group__3 ;
    public final void rule__Transition__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArduinoML.g:1153:1: ( rule__Transition__Group__2__Impl rule__Transition__Group__3 )
            // InternalArduinoML.g:1154:2: rule__Transition__Group__2__Impl rule__Transition__Group__3
            {
            pushFollow(FOLLOW_20);
            rule__Transition__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Transition__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Transition__Group__2"


    // $ANTLR start "rule__Transition__Group__2__Impl"
    // InternalArduinoML.g:1161:1: rule__Transition__Group__2__Impl : ( ( rule__Transition__ValueAssignment_2 ) ) ;
    public final void rule__Transition__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArduinoML.g:1165:1: ( ( ( rule__Transition__ValueAssignment_2 ) ) )
            // InternalArduinoML.g:1166:1: ( ( rule__Transition__ValueAssignment_2 ) )
            {
            // InternalArduinoML.g:1166:1: ( ( rule__Transition__ValueAssignment_2 ) )
            // InternalArduinoML.g:1167:2: ( rule__Transition__ValueAssignment_2 )
            {
             before(grammarAccess.getTransitionAccess().getValueAssignment_2()); 
            // InternalArduinoML.g:1168:2: ( rule__Transition__ValueAssignment_2 )
            // InternalArduinoML.g:1168:3: rule__Transition__ValueAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__Transition__ValueAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getTransitionAccess().getValueAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Transition__Group__2__Impl"


    // $ANTLR start "rule__Transition__Group__3"
    // InternalArduinoML.g:1176:1: rule__Transition__Group__3 : rule__Transition__Group__3__Impl rule__Transition__Group__4 ;
    public final void rule__Transition__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArduinoML.g:1180:1: ( rule__Transition__Group__3__Impl rule__Transition__Group__4 )
            // InternalArduinoML.g:1181:2: rule__Transition__Group__3__Impl rule__Transition__Group__4
            {
            pushFollow(FOLLOW_3);
            rule__Transition__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Transition__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Transition__Group__3"


    // $ANTLR start "rule__Transition__Group__3__Impl"
    // InternalArduinoML.g:1188:1: rule__Transition__Group__3__Impl : ( '=>' ) ;
    public final void rule__Transition__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArduinoML.g:1192:1: ( ( '=>' ) )
            // InternalArduinoML.g:1193:1: ( '=>' )
            {
            // InternalArduinoML.g:1193:1: ( '=>' )
            // InternalArduinoML.g:1194:2: '=>'
            {
             before(grammarAccess.getTransitionAccess().getEqualsSignGreaterThanSignKeyword_3()); 
            match(input,25,FOLLOW_2); 
             after(grammarAccess.getTransitionAccess().getEqualsSignGreaterThanSignKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Transition__Group__3__Impl"


    // $ANTLR start "rule__Transition__Group__4"
    // InternalArduinoML.g:1203:1: rule__Transition__Group__4 : rule__Transition__Group__4__Impl ;
    public final void rule__Transition__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArduinoML.g:1207:1: ( rule__Transition__Group__4__Impl )
            // InternalArduinoML.g:1208:2: rule__Transition__Group__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Transition__Group__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Transition__Group__4"


    // $ANTLR start "rule__Transition__Group__4__Impl"
    // InternalArduinoML.g:1214:1: rule__Transition__Group__4__Impl : ( ( rule__Transition__NextAssignment_4 ) ) ;
    public final void rule__Transition__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArduinoML.g:1218:1: ( ( ( rule__Transition__NextAssignment_4 ) ) )
            // InternalArduinoML.g:1219:1: ( ( rule__Transition__NextAssignment_4 ) )
            {
            // InternalArduinoML.g:1219:1: ( ( rule__Transition__NextAssignment_4 ) )
            // InternalArduinoML.g:1220:2: ( rule__Transition__NextAssignment_4 )
            {
             before(grammarAccess.getTransitionAccess().getNextAssignment_4()); 
            // InternalArduinoML.g:1221:2: ( rule__Transition__NextAssignment_4 )
            // InternalArduinoML.g:1221:3: rule__Transition__NextAssignment_4
            {
            pushFollow(FOLLOW_2);
            rule__Transition__NextAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getTransitionAccess().getNextAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Transition__Group__4__Impl"


    // $ANTLR start "rule__App__NameAssignment_1"
    // InternalArduinoML.g:1230:1: rule__App__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__App__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArduinoML.g:1234:1: ( ( RULE_ID ) )
            // InternalArduinoML.g:1235:2: ( RULE_ID )
            {
            // InternalArduinoML.g:1235:2: ( RULE_ID )
            // InternalArduinoML.g:1236:3: RULE_ID
            {
             before(grammarAccess.getAppAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getAppAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__App__NameAssignment_1"


    // $ANTLR start "rule__App__InitialAssignment_4"
    // InternalArduinoML.g:1245:1: rule__App__InitialAssignment_4 : ( ( RULE_ID ) ) ;
    public final void rule__App__InitialAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArduinoML.g:1249:1: ( ( ( RULE_ID ) ) )
            // InternalArduinoML.g:1250:2: ( ( RULE_ID ) )
            {
            // InternalArduinoML.g:1250:2: ( ( RULE_ID ) )
            // InternalArduinoML.g:1251:3: ( RULE_ID )
            {
             before(grammarAccess.getAppAccess().getInitialStateCrossReference_4_0()); 
            // InternalArduinoML.g:1252:3: ( RULE_ID )
            // InternalArduinoML.g:1253:4: RULE_ID
            {
             before(grammarAccess.getAppAccess().getInitialStateIDTerminalRuleCall_4_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getAppAccess().getInitialStateIDTerminalRuleCall_4_0_1()); 

            }

             after(grammarAccess.getAppAccess().getInitialStateCrossReference_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__App__InitialAssignment_4"


    // $ANTLR start "rule__App__BricksAssignment_7"
    // InternalArduinoML.g:1264:1: rule__App__BricksAssignment_7 : ( ruleBrick ) ;
    public final void rule__App__BricksAssignment_7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArduinoML.g:1268:1: ( ( ruleBrick ) )
            // InternalArduinoML.g:1269:2: ( ruleBrick )
            {
            // InternalArduinoML.g:1269:2: ( ruleBrick )
            // InternalArduinoML.g:1270:3: ruleBrick
            {
             before(grammarAccess.getAppAccess().getBricksBrickParserRuleCall_7_0()); 
            pushFollow(FOLLOW_2);
            ruleBrick();

            state._fsp--;

             after(grammarAccess.getAppAccess().getBricksBrickParserRuleCall_7_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__App__BricksAssignment_7"


    // $ANTLR start "rule__App__BricksAssignment_8"
    // InternalArduinoML.g:1279:1: rule__App__BricksAssignment_8 : ( ruleBrick ) ;
    public final void rule__App__BricksAssignment_8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArduinoML.g:1283:1: ( ( ruleBrick ) )
            // InternalArduinoML.g:1284:2: ( ruleBrick )
            {
            // InternalArduinoML.g:1284:2: ( ruleBrick )
            // InternalArduinoML.g:1285:3: ruleBrick
            {
             before(grammarAccess.getAppAccess().getBricksBrickParserRuleCall_8_0()); 
            pushFollow(FOLLOW_2);
            ruleBrick();

            state._fsp--;

             after(grammarAccess.getAppAccess().getBricksBrickParserRuleCall_8_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__App__BricksAssignment_8"


    // $ANTLR start "rule__App__StatesAssignment_10"
    // InternalArduinoML.g:1294:1: rule__App__StatesAssignment_10 : ( ruleState ) ;
    public final void rule__App__StatesAssignment_10() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArduinoML.g:1298:1: ( ( ruleState ) )
            // InternalArduinoML.g:1299:2: ( ruleState )
            {
            // InternalArduinoML.g:1299:2: ( ruleState )
            // InternalArduinoML.g:1300:3: ruleState
            {
             before(grammarAccess.getAppAccess().getStatesStateParserRuleCall_10_0()); 
            pushFollow(FOLLOW_2);
            ruleState();

            state._fsp--;

             after(grammarAccess.getAppAccess().getStatesStateParserRuleCall_10_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__App__StatesAssignment_10"


    // $ANTLR start "rule__App__StatesAssignment_11"
    // InternalArduinoML.g:1309:1: rule__App__StatesAssignment_11 : ( ruleState ) ;
    public final void rule__App__StatesAssignment_11() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArduinoML.g:1313:1: ( ( ruleState ) )
            // InternalArduinoML.g:1314:2: ( ruleState )
            {
            // InternalArduinoML.g:1314:2: ( ruleState )
            // InternalArduinoML.g:1315:3: ruleState
            {
             before(grammarAccess.getAppAccess().getStatesStateParserRuleCall_11_0()); 
            pushFollow(FOLLOW_2);
            ruleState();

            state._fsp--;

             after(grammarAccess.getAppAccess().getStatesStateParserRuleCall_11_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__App__StatesAssignment_11"


    // $ANTLR start "rule__Brick__NameAssignment_1"
    // InternalArduinoML.g:1324:1: rule__Brick__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Brick__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArduinoML.g:1328:1: ( ( RULE_ID ) )
            // InternalArduinoML.g:1329:2: ( RULE_ID )
            {
            // InternalArduinoML.g:1329:2: ( RULE_ID )
            // InternalArduinoML.g:1330:3: RULE_ID
            {
             before(grammarAccess.getBrickAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getBrickAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Brick__NameAssignment_1"


    // $ANTLR start "rule__Brick__PinAssignment_3"
    // InternalArduinoML.g:1339:1: rule__Brick__PinAssignment_3 : ( RULE_INT ) ;
    public final void rule__Brick__PinAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArduinoML.g:1343:1: ( ( RULE_INT ) )
            // InternalArduinoML.g:1344:2: ( RULE_INT )
            {
            // InternalArduinoML.g:1344:2: ( RULE_INT )
            // InternalArduinoML.g:1345:3: RULE_INT
            {
             before(grammarAccess.getBrickAccess().getPinINTTerminalRuleCall_3_0()); 
            match(input,RULE_INT,FOLLOW_2); 
             after(grammarAccess.getBrickAccess().getPinINTTerminalRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Brick__PinAssignment_3"


    // $ANTLR start "rule__State__NameAssignment_0"
    // InternalArduinoML.g:1354:1: rule__State__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__State__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArduinoML.g:1358:1: ( ( RULE_ID ) )
            // InternalArduinoML.g:1359:2: ( RULE_ID )
            {
            // InternalArduinoML.g:1359:2: ( RULE_ID )
            // InternalArduinoML.g:1360:3: RULE_ID
            {
             before(grammarAccess.getStateAccess().getNameIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getStateAccess().getNameIDTerminalRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__State__NameAssignment_0"


    // $ANTLR start "rule__State__ActionsAssignment_2"
    // InternalArduinoML.g:1369:1: rule__State__ActionsAssignment_2 : ( ruleAction ) ;
    public final void rule__State__ActionsAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArduinoML.g:1373:1: ( ( ruleAction ) )
            // InternalArduinoML.g:1374:2: ( ruleAction )
            {
            // InternalArduinoML.g:1374:2: ( ruleAction )
            // InternalArduinoML.g:1375:3: ruleAction
            {
             before(grammarAccess.getStateAccess().getActionsActionParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleAction();

            state._fsp--;

             after(grammarAccess.getStateAccess().getActionsActionParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__State__ActionsAssignment_2"


    // $ANTLR start "rule__State__ActionsAssignment_3"
    // InternalArduinoML.g:1384:1: rule__State__ActionsAssignment_3 : ( ruleAction ) ;
    public final void rule__State__ActionsAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArduinoML.g:1388:1: ( ( ruleAction ) )
            // InternalArduinoML.g:1389:2: ( ruleAction )
            {
            // InternalArduinoML.g:1389:2: ( ruleAction )
            // InternalArduinoML.g:1390:3: ruleAction
            {
             before(grammarAccess.getStateAccess().getActionsActionParserRuleCall_3_0()); 
            pushFollow(FOLLOW_2);
            ruleAction();

            state._fsp--;

             after(grammarAccess.getStateAccess().getActionsActionParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__State__ActionsAssignment_3"


    // $ANTLR start "rule__State__TransitionAssignment_4"
    // InternalArduinoML.g:1399:1: rule__State__TransitionAssignment_4 : ( ruleTransition ) ;
    public final void rule__State__TransitionAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArduinoML.g:1403:1: ( ( ruleTransition ) )
            // InternalArduinoML.g:1404:2: ( ruleTransition )
            {
            // InternalArduinoML.g:1404:2: ( ruleTransition )
            // InternalArduinoML.g:1405:3: ruleTransition
            {
             before(grammarAccess.getStateAccess().getTransitionTransitionParserRuleCall_4_0()); 
            pushFollow(FOLLOW_2);
            ruleTransition();

            state._fsp--;

             after(grammarAccess.getStateAccess().getTransitionTransitionParserRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__State__TransitionAssignment_4"


    // $ANTLR start "rule__Action__ActuatorAssignment_0"
    // InternalArduinoML.g:1414:1: rule__Action__ActuatorAssignment_0 : ( ( RULE_ID ) ) ;
    public final void rule__Action__ActuatorAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArduinoML.g:1418:1: ( ( ( RULE_ID ) ) )
            // InternalArduinoML.g:1419:2: ( ( RULE_ID ) )
            {
            // InternalArduinoML.g:1419:2: ( ( RULE_ID ) )
            // InternalArduinoML.g:1420:3: ( RULE_ID )
            {
             before(grammarAccess.getActionAccess().getActuatorActuatorCrossReference_0_0()); 
            // InternalArduinoML.g:1421:3: ( RULE_ID )
            // InternalArduinoML.g:1422:4: RULE_ID
            {
             before(grammarAccess.getActionAccess().getActuatorActuatorIDTerminalRuleCall_0_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getActionAccess().getActuatorActuatorIDTerminalRuleCall_0_0_1()); 

            }

             after(grammarAccess.getActionAccess().getActuatorActuatorCrossReference_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Action__ActuatorAssignment_0"


    // $ANTLR start "rule__Action__ValueAssignment_2"
    // InternalArduinoML.g:1433:1: rule__Action__ValueAssignment_2 : ( ruleSignal ) ;
    public final void rule__Action__ValueAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArduinoML.g:1437:1: ( ( ruleSignal ) )
            // InternalArduinoML.g:1438:2: ( ruleSignal )
            {
            // InternalArduinoML.g:1438:2: ( ruleSignal )
            // InternalArduinoML.g:1439:3: ruleSignal
            {
             before(grammarAccess.getActionAccess().getValueSignalEnumRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleSignal();

            state._fsp--;

             after(grammarAccess.getActionAccess().getValueSignalEnumRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Action__ValueAssignment_2"


    // $ANTLR start "rule__Transition__SensorAssignment_0"
    // InternalArduinoML.g:1448:1: rule__Transition__SensorAssignment_0 : ( ( RULE_ID ) ) ;
    public final void rule__Transition__SensorAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArduinoML.g:1452:1: ( ( ( RULE_ID ) ) )
            // InternalArduinoML.g:1453:2: ( ( RULE_ID ) )
            {
            // InternalArduinoML.g:1453:2: ( ( RULE_ID ) )
            // InternalArduinoML.g:1454:3: ( RULE_ID )
            {
             before(grammarAccess.getTransitionAccess().getSensorSensorCrossReference_0_0()); 
            // InternalArduinoML.g:1455:3: ( RULE_ID )
            // InternalArduinoML.g:1456:4: RULE_ID
            {
             before(grammarAccess.getTransitionAccess().getSensorSensorIDTerminalRuleCall_0_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getTransitionAccess().getSensorSensorIDTerminalRuleCall_0_0_1()); 

            }

             after(grammarAccess.getTransitionAccess().getSensorSensorCrossReference_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Transition__SensorAssignment_0"


    // $ANTLR start "rule__Transition__ValueAssignment_2"
    // InternalArduinoML.g:1467:1: rule__Transition__ValueAssignment_2 : ( ruleSignal ) ;
    public final void rule__Transition__ValueAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArduinoML.g:1471:1: ( ( ruleSignal ) )
            // InternalArduinoML.g:1472:2: ( ruleSignal )
            {
            // InternalArduinoML.g:1472:2: ( ruleSignal )
            // InternalArduinoML.g:1473:3: ruleSignal
            {
             before(grammarAccess.getTransitionAccess().getValueSignalEnumRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleSignal();

            state._fsp--;

             after(grammarAccess.getTransitionAccess().getValueSignalEnumRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Transition__ValueAssignment_2"


    // $ANTLR start "rule__Transition__NextAssignment_4"
    // InternalArduinoML.g:1482:1: rule__Transition__NextAssignment_4 : ( ( RULE_ID ) ) ;
    public final void rule__Transition__NextAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArduinoML.g:1486:1: ( ( ( RULE_ID ) ) )
            // InternalArduinoML.g:1487:2: ( ( RULE_ID ) )
            {
            // InternalArduinoML.g:1487:2: ( ( RULE_ID ) )
            // InternalArduinoML.g:1488:3: ( RULE_ID )
            {
             before(grammarAccess.getTransitionAccess().getNextStateCrossReference_4_0()); 
            // InternalArduinoML.g:1489:3: ( RULE_ID )
            // InternalArduinoML.g:1490:4: RULE_ID
            {
             before(grammarAccess.getTransitionAccess().getNextStateIDTerminalRuleCall_4_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getTransitionAccess().getNextStateIDTerminalRuleCall_4_0_1()); 

            }

             after(grammarAccess.getTransitionAccess().getNextStateCrossReference_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Transition__NextAssignment_4"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000600000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000640000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000600002L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000080010L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000000001800L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000002000000L});

}