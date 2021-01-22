package fr.polytech.si5.dsl.arduino.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import fr.polytech.si5.dsl.arduino.services.ArduinoMLGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalArduinoMLParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'app'", "'initial'", "'state'", "'{'", "'bricks'", "'states'", "'}'", "':'", "'Actuator'", "'Sensor'", "'<='", "'is'", "'=>'", "'HIGH'", "'LOW'"
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

        public InternalArduinoMLParser(TokenStream input, ArduinoMLGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "App";
       	}

       	@Override
       	protected ArduinoMLGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleApp"
    // InternalArduinoML.g:65:1: entryRuleApp returns [EObject current=null] : iv_ruleApp= ruleApp EOF ;
    public final EObject entryRuleApp() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleApp = null;


        try {
            // InternalArduinoML.g:65:44: (iv_ruleApp= ruleApp EOF )
            // InternalArduinoML.g:66:2: iv_ruleApp= ruleApp EOF
            {
             newCompositeNode(grammarAccess.getAppRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleApp=ruleApp();

            state._fsp--;

             current =iv_ruleApp; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleApp"


    // $ANTLR start "ruleApp"
    // InternalArduinoML.g:72:1: ruleApp returns [EObject current=null] : (otherlv_0= 'app' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'initial' otherlv_3= 'state' ( (otherlv_4= RULE_ID ) ) otherlv_5= '{' otherlv_6= 'bricks' ( (lv_bricks_7_0= ruleBrick ) ) ( (lv_bricks_8_0= ruleBrick ) )* otherlv_9= 'states' ( (lv_states_10_0= ruleState ) ) ( (lv_states_11_0= ruleState ) )* otherlv_12= '}' ) ;
    public final EObject ruleApp() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_9=null;
        Token otherlv_12=null;
        EObject lv_bricks_7_0 = null;

        EObject lv_bricks_8_0 = null;

        EObject lv_states_10_0 = null;

        EObject lv_states_11_0 = null;



        	enterRule();

        try {
            // InternalArduinoML.g:78:2: ( (otherlv_0= 'app' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'initial' otherlv_3= 'state' ( (otherlv_4= RULE_ID ) ) otherlv_5= '{' otherlv_6= 'bricks' ( (lv_bricks_7_0= ruleBrick ) ) ( (lv_bricks_8_0= ruleBrick ) )* otherlv_9= 'states' ( (lv_states_10_0= ruleState ) ) ( (lv_states_11_0= ruleState ) )* otherlv_12= '}' ) )
            // InternalArduinoML.g:79:2: (otherlv_0= 'app' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'initial' otherlv_3= 'state' ( (otherlv_4= RULE_ID ) ) otherlv_5= '{' otherlv_6= 'bricks' ( (lv_bricks_7_0= ruleBrick ) ) ( (lv_bricks_8_0= ruleBrick ) )* otherlv_9= 'states' ( (lv_states_10_0= ruleState ) ) ( (lv_states_11_0= ruleState ) )* otherlv_12= '}' )
            {
            // InternalArduinoML.g:79:2: (otherlv_0= 'app' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'initial' otherlv_3= 'state' ( (otherlv_4= RULE_ID ) ) otherlv_5= '{' otherlv_6= 'bricks' ( (lv_bricks_7_0= ruleBrick ) ) ( (lv_bricks_8_0= ruleBrick ) )* otherlv_9= 'states' ( (lv_states_10_0= ruleState ) ) ( (lv_states_11_0= ruleState ) )* otherlv_12= '}' )
            // InternalArduinoML.g:80:3: otherlv_0= 'app' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'initial' otherlv_3= 'state' ( (otherlv_4= RULE_ID ) ) otherlv_5= '{' otherlv_6= 'bricks' ( (lv_bricks_7_0= ruleBrick ) ) ( (lv_bricks_8_0= ruleBrick ) )* otherlv_9= 'states' ( (lv_states_10_0= ruleState ) ) ( (lv_states_11_0= ruleState ) )* otherlv_12= '}'
            {
            otherlv_0=(Token)match(input,11,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getAppAccess().getAppKeyword_0());
            		
            // InternalArduinoML.g:84:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalArduinoML.g:85:4: (lv_name_1_0= RULE_ID )
            {
            // InternalArduinoML.g:85:4: (lv_name_1_0= RULE_ID )
            // InternalArduinoML.g:86:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_4); 

            					newLeafNode(lv_name_1_0, grammarAccess.getAppAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getAppRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,12,FOLLOW_5); 

            			newLeafNode(otherlv_2, grammarAccess.getAppAccess().getInitialKeyword_2());
            		
            otherlv_3=(Token)match(input,13,FOLLOW_3); 

            			newLeafNode(otherlv_3, grammarAccess.getAppAccess().getStateKeyword_3());
            		
            // InternalArduinoML.g:110:3: ( (otherlv_4= RULE_ID ) )
            // InternalArduinoML.g:111:4: (otherlv_4= RULE_ID )
            {
            // InternalArduinoML.g:111:4: (otherlv_4= RULE_ID )
            // InternalArduinoML.g:112:5: otherlv_4= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getAppRule());
            					}
            				
            otherlv_4=(Token)match(input,RULE_ID,FOLLOW_6); 

            					newLeafNode(otherlv_4, grammarAccess.getAppAccess().getInitialStateCrossReference_4_0());
            				

            }


            }

            otherlv_5=(Token)match(input,14,FOLLOW_7); 

            			newLeafNode(otherlv_5, grammarAccess.getAppAccess().getLeftCurlyBracketKeyword_5());
            		
            otherlv_6=(Token)match(input,15,FOLLOW_8); 

            			newLeafNode(otherlv_6, grammarAccess.getAppAccess().getBricksKeyword_6());
            		
            // InternalArduinoML.g:131:3: ( (lv_bricks_7_0= ruleBrick ) )
            // InternalArduinoML.g:132:4: (lv_bricks_7_0= ruleBrick )
            {
            // InternalArduinoML.g:132:4: (lv_bricks_7_0= ruleBrick )
            // InternalArduinoML.g:133:5: lv_bricks_7_0= ruleBrick
            {

            					newCompositeNode(grammarAccess.getAppAccess().getBricksBrickParserRuleCall_7_0());
            				
            pushFollow(FOLLOW_9);
            lv_bricks_7_0=ruleBrick();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getAppRule());
            					}
            					add(
            						current,
            						"bricks",
            						lv_bricks_7_0,
            						"fr.polytech.si5.dsl.arduino.ArduinoML.Brick");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalArduinoML.g:150:3: ( (lv_bricks_8_0= ruleBrick ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>=19 && LA1_0<=20)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalArduinoML.g:151:4: (lv_bricks_8_0= ruleBrick )
            	    {
            	    // InternalArduinoML.g:151:4: (lv_bricks_8_0= ruleBrick )
            	    // InternalArduinoML.g:152:5: lv_bricks_8_0= ruleBrick
            	    {

            	    					newCompositeNode(grammarAccess.getAppAccess().getBricksBrickParserRuleCall_8_0());
            	    				
            	    pushFollow(FOLLOW_9);
            	    lv_bricks_8_0=ruleBrick();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getAppRule());
            	    					}
            	    					add(
            	    						current,
            	    						"bricks",
            	    						lv_bricks_8_0,
            	    						"fr.polytech.si5.dsl.arduino.ArduinoML.Brick");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            otherlv_9=(Token)match(input,16,FOLLOW_3); 

            			newLeafNode(otherlv_9, grammarAccess.getAppAccess().getStatesKeyword_9());
            		
            // InternalArduinoML.g:173:3: ( (lv_states_10_0= ruleState ) )
            // InternalArduinoML.g:174:4: (lv_states_10_0= ruleState )
            {
            // InternalArduinoML.g:174:4: (lv_states_10_0= ruleState )
            // InternalArduinoML.g:175:5: lv_states_10_0= ruleState
            {

            					newCompositeNode(grammarAccess.getAppAccess().getStatesStateParserRuleCall_10_0());
            				
            pushFollow(FOLLOW_10);
            lv_states_10_0=ruleState();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getAppRule());
            					}
            					add(
            						current,
            						"states",
            						lv_states_10_0,
            						"fr.polytech.si5.dsl.arduino.ArduinoML.State");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalArduinoML.g:192:3: ( (lv_states_11_0= ruleState ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==RULE_ID) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalArduinoML.g:193:4: (lv_states_11_0= ruleState )
            	    {
            	    // InternalArduinoML.g:193:4: (lv_states_11_0= ruleState )
            	    // InternalArduinoML.g:194:5: lv_states_11_0= ruleState
            	    {

            	    					newCompositeNode(grammarAccess.getAppAccess().getStatesStateParserRuleCall_11_0());
            	    				
            	    pushFollow(FOLLOW_10);
            	    lv_states_11_0=ruleState();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getAppRule());
            	    					}
            	    					add(
            	    						current,
            	    						"states",
            	    						lv_states_11_0,
            	    						"fr.polytech.si5.dsl.arduino.ArduinoML.State");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            otherlv_12=(Token)match(input,17,FOLLOW_2); 

            			newLeafNode(otherlv_12, grammarAccess.getAppAccess().getRightCurlyBracketKeyword_12());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleApp"


    // $ANTLR start "entryRuleBrick"
    // InternalArduinoML.g:219:1: entryRuleBrick returns [EObject current=null] : iv_ruleBrick= ruleBrick EOF ;
    public final EObject entryRuleBrick() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBrick = null;


        try {
            // InternalArduinoML.g:219:46: (iv_ruleBrick= ruleBrick EOF )
            // InternalArduinoML.g:220:2: iv_ruleBrick= ruleBrick EOF
            {
             newCompositeNode(grammarAccess.getBrickRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleBrick=ruleBrick();

            state._fsp--;

             current =iv_ruleBrick; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBrick"


    // $ANTLR start "ruleBrick"
    // InternalArduinoML.g:226:1: ruleBrick returns [EObject current=null] : ( (this_Actuator_0= ruleActuator | this_Sensor_1= ruleSensor ) ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ':' ( (lv_pin_4_0= RULE_INT ) ) ) ;
    public final EObject ruleBrick() throws RecognitionException {
        EObject current = null;

        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token lv_pin_4_0=null;
        EObject this_Actuator_0 = null;

        EObject this_Sensor_1 = null;



        	enterRule();

        try {
            // InternalArduinoML.g:232:2: ( ( (this_Actuator_0= ruleActuator | this_Sensor_1= ruleSensor ) ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ':' ( (lv_pin_4_0= RULE_INT ) ) ) )
            // InternalArduinoML.g:233:2: ( (this_Actuator_0= ruleActuator | this_Sensor_1= ruleSensor ) ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ':' ( (lv_pin_4_0= RULE_INT ) ) )
            {
            // InternalArduinoML.g:233:2: ( (this_Actuator_0= ruleActuator | this_Sensor_1= ruleSensor ) ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ':' ( (lv_pin_4_0= RULE_INT ) ) )
            // InternalArduinoML.g:234:3: (this_Actuator_0= ruleActuator | this_Sensor_1= ruleSensor ) ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ':' ( (lv_pin_4_0= RULE_INT ) )
            {
            // InternalArduinoML.g:234:3: (this_Actuator_0= ruleActuator | this_Sensor_1= ruleSensor )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==19) ) {
                alt3=1;
            }
            else if ( (LA3_0==20) ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // InternalArduinoML.g:235:4: this_Actuator_0= ruleActuator
                    {

                    				newCompositeNode(grammarAccess.getBrickAccess().getActuatorParserRuleCall_0_0());
                    			
                    pushFollow(FOLLOW_3);
                    this_Actuator_0=ruleActuator();

                    state._fsp--;


                    				current = this_Actuator_0;
                    				afterParserOrEnumRuleCall();
                    			

                    }
                    break;
                case 2 :
                    // InternalArduinoML.g:244:4: this_Sensor_1= ruleSensor
                    {

                    				newCompositeNode(grammarAccess.getBrickAccess().getSensorParserRuleCall_0_1());
                    			
                    pushFollow(FOLLOW_3);
                    this_Sensor_1=ruleSensor();

                    state._fsp--;


                    				current = this_Sensor_1;
                    				afterParserOrEnumRuleCall();
                    			

                    }
                    break;

            }

            // InternalArduinoML.g:253:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalArduinoML.g:254:4: (lv_name_2_0= RULE_ID )
            {
            // InternalArduinoML.g:254:4: (lv_name_2_0= RULE_ID )
            // InternalArduinoML.g:255:5: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_11); 

            					newLeafNode(lv_name_2_0, grammarAccess.getBrickAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getBrickRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_2_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_3=(Token)match(input,18,FOLLOW_12); 

            			newLeafNode(otherlv_3, grammarAccess.getBrickAccess().getColonKeyword_2());
            		
            // InternalArduinoML.g:275:3: ( (lv_pin_4_0= RULE_INT ) )
            // InternalArduinoML.g:276:4: (lv_pin_4_0= RULE_INT )
            {
            // InternalArduinoML.g:276:4: (lv_pin_4_0= RULE_INT )
            // InternalArduinoML.g:277:5: lv_pin_4_0= RULE_INT
            {
            lv_pin_4_0=(Token)match(input,RULE_INT,FOLLOW_2); 

            					newLeafNode(lv_pin_4_0, grammarAccess.getBrickAccess().getPinINTTerminalRuleCall_3_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getBrickRule());
            					}
            					setWithLastConsumed(
            						current,
            						"pin",
            						lv_pin_4_0,
            						"org.eclipse.xtext.common.Terminals.INT");
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBrick"


    // $ANTLR start "entryRuleActuator"
    // InternalArduinoML.g:297:1: entryRuleActuator returns [EObject current=null] : iv_ruleActuator= ruleActuator EOF ;
    public final EObject entryRuleActuator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleActuator = null;


        try {
            // InternalArduinoML.g:297:49: (iv_ruleActuator= ruleActuator EOF )
            // InternalArduinoML.g:298:2: iv_ruleActuator= ruleActuator EOF
            {
             newCompositeNode(grammarAccess.getActuatorRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleActuator=ruleActuator();

            state._fsp--;

             current =iv_ruleActuator; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleActuator"


    // $ANTLR start "ruleActuator"
    // InternalArduinoML.g:304:1: ruleActuator returns [EObject current=null] : ( () otherlv_1= 'Actuator' ) ;
    public final EObject ruleActuator() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalArduinoML.g:310:2: ( ( () otherlv_1= 'Actuator' ) )
            // InternalArduinoML.g:311:2: ( () otherlv_1= 'Actuator' )
            {
            // InternalArduinoML.g:311:2: ( () otherlv_1= 'Actuator' )
            // InternalArduinoML.g:312:3: () otherlv_1= 'Actuator'
            {
            // InternalArduinoML.g:312:3: ()
            // InternalArduinoML.g:313:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getActuatorAccess().getActuatorAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,19,FOLLOW_2); 

            			newLeafNode(otherlv_1, grammarAccess.getActuatorAccess().getActuatorKeyword_1());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleActuator"


    // $ANTLR start "entryRuleSensor"
    // InternalArduinoML.g:327:1: entryRuleSensor returns [EObject current=null] : iv_ruleSensor= ruleSensor EOF ;
    public final EObject entryRuleSensor() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSensor = null;


        try {
            // InternalArduinoML.g:327:47: (iv_ruleSensor= ruleSensor EOF )
            // InternalArduinoML.g:328:2: iv_ruleSensor= ruleSensor EOF
            {
             newCompositeNode(grammarAccess.getSensorRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSensor=ruleSensor();

            state._fsp--;

             current =iv_ruleSensor; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSensor"


    // $ANTLR start "ruleSensor"
    // InternalArduinoML.g:334:1: ruleSensor returns [EObject current=null] : ( () otherlv_1= 'Sensor' ) ;
    public final EObject ruleSensor() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalArduinoML.g:340:2: ( ( () otherlv_1= 'Sensor' ) )
            // InternalArduinoML.g:341:2: ( () otherlv_1= 'Sensor' )
            {
            // InternalArduinoML.g:341:2: ( () otherlv_1= 'Sensor' )
            // InternalArduinoML.g:342:3: () otherlv_1= 'Sensor'
            {
            // InternalArduinoML.g:342:3: ()
            // InternalArduinoML.g:343:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getSensorAccess().getSensorAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,20,FOLLOW_2); 

            			newLeafNode(otherlv_1, grammarAccess.getSensorAccess().getSensorKeyword_1());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSensor"


    // $ANTLR start "entryRuleState"
    // InternalArduinoML.g:357:1: entryRuleState returns [EObject current=null] : iv_ruleState= ruleState EOF ;
    public final EObject entryRuleState() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleState = null;


        try {
            // InternalArduinoML.g:357:46: (iv_ruleState= ruleState EOF )
            // InternalArduinoML.g:358:2: iv_ruleState= ruleState EOF
            {
             newCompositeNode(grammarAccess.getStateRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleState=ruleState();

            state._fsp--;

             current =iv_ruleState; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleState"


    // $ANTLR start "ruleState"
    // InternalArduinoML.g:364:1: ruleState returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '{' ( (lv_actions_2_0= ruleAction ) ) ( (lv_actions_3_0= ruleAction ) )* ( (lv_transition_4_0= ruleTransition ) ) otherlv_5= '}' ) ;
    public final EObject ruleState() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_5=null;
        EObject lv_actions_2_0 = null;

        EObject lv_actions_3_0 = null;

        EObject lv_transition_4_0 = null;



        	enterRule();

        try {
            // InternalArduinoML.g:370:2: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '{' ( (lv_actions_2_0= ruleAction ) ) ( (lv_actions_3_0= ruleAction ) )* ( (lv_transition_4_0= ruleTransition ) ) otherlv_5= '}' ) )
            // InternalArduinoML.g:371:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '{' ( (lv_actions_2_0= ruleAction ) ) ( (lv_actions_3_0= ruleAction ) )* ( (lv_transition_4_0= ruleTransition ) ) otherlv_5= '}' )
            {
            // InternalArduinoML.g:371:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '{' ( (lv_actions_2_0= ruleAction ) ) ( (lv_actions_3_0= ruleAction ) )* ( (lv_transition_4_0= ruleTransition ) ) otherlv_5= '}' )
            // InternalArduinoML.g:372:3: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '{' ( (lv_actions_2_0= ruleAction ) ) ( (lv_actions_3_0= ruleAction ) )* ( (lv_transition_4_0= ruleTransition ) ) otherlv_5= '}'
            {
            // InternalArduinoML.g:372:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalArduinoML.g:373:4: (lv_name_0_0= RULE_ID )
            {
            // InternalArduinoML.g:373:4: (lv_name_0_0= RULE_ID )
            // InternalArduinoML.g:374:5: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_6); 

            					newLeafNode(lv_name_0_0, grammarAccess.getStateAccess().getNameIDTerminalRuleCall_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getStateRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_0_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_1=(Token)match(input,14,FOLLOW_3); 

            			newLeafNode(otherlv_1, grammarAccess.getStateAccess().getLeftCurlyBracketKeyword_1());
            		
            // InternalArduinoML.g:394:3: ( (lv_actions_2_0= ruleAction ) )
            // InternalArduinoML.g:395:4: (lv_actions_2_0= ruleAction )
            {
            // InternalArduinoML.g:395:4: (lv_actions_2_0= ruleAction )
            // InternalArduinoML.g:396:5: lv_actions_2_0= ruleAction
            {

            					newCompositeNode(grammarAccess.getStateAccess().getActionsActionParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_3);
            lv_actions_2_0=ruleAction();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getStateRule());
            					}
            					add(
            						current,
            						"actions",
            						lv_actions_2_0,
            						"fr.polytech.si5.dsl.arduino.ArduinoML.Action");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalArduinoML.g:413:3: ( (lv_actions_3_0= ruleAction ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==RULE_ID) ) {
                    int LA4_1 = input.LA(2);

                    if ( (LA4_1==21) ) {
                        alt4=1;
                    }


                }


                switch (alt4) {
            	case 1 :
            	    // InternalArduinoML.g:414:4: (lv_actions_3_0= ruleAction )
            	    {
            	    // InternalArduinoML.g:414:4: (lv_actions_3_0= ruleAction )
            	    // InternalArduinoML.g:415:5: lv_actions_3_0= ruleAction
            	    {

            	    					newCompositeNode(grammarAccess.getStateAccess().getActionsActionParserRuleCall_3_0());
            	    				
            	    pushFollow(FOLLOW_3);
            	    lv_actions_3_0=ruleAction();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getStateRule());
            	    					}
            	    					add(
            	    						current,
            	    						"actions",
            	    						lv_actions_3_0,
            	    						"fr.polytech.si5.dsl.arduino.ArduinoML.Action");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

            // InternalArduinoML.g:432:3: ( (lv_transition_4_0= ruleTransition ) )
            // InternalArduinoML.g:433:4: (lv_transition_4_0= ruleTransition )
            {
            // InternalArduinoML.g:433:4: (lv_transition_4_0= ruleTransition )
            // InternalArduinoML.g:434:5: lv_transition_4_0= ruleTransition
            {

            					newCompositeNode(grammarAccess.getStateAccess().getTransitionTransitionParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_13);
            lv_transition_4_0=ruleTransition();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getStateRule());
            					}
            					set(
            						current,
            						"transition",
            						lv_transition_4_0,
            						"fr.polytech.si5.dsl.arduino.ArduinoML.Transition");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_5=(Token)match(input,17,FOLLOW_2); 

            			newLeafNode(otherlv_5, grammarAccess.getStateAccess().getRightCurlyBracketKeyword_5());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleState"


    // $ANTLR start "entryRuleAction"
    // InternalArduinoML.g:459:1: entryRuleAction returns [EObject current=null] : iv_ruleAction= ruleAction EOF ;
    public final EObject entryRuleAction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAction = null;


        try {
            // InternalArduinoML.g:459:47: (iv_ruleAction= ruleAction EOF )
            // InternalArduinoML.g:460:2: iv_ruleAction= ruleAction EOF
            {
             newCompositeNode(grammarAccess.getActionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAction=ruleAction();

            state._fsp--;

             current =iv_ruleAction; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAction"


    // $ANTLR start "ruleAction"
    // InternalArduinoML.g:466:1: ruleAction returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '<=' ( (lv_value_2_0= ruleSignal ) ) ) ;
    public final EObject ruleAction() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Enumerator lv_value_2_0 = null;



        	enterRule();

        try {
            // InternalArduinoML.g:472:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '<=' ( (lv_value_2_0= ruleSignal ) ) ) )
            // InternalArduinoML.g:473:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '<=' ( (lv_value_2_0= ruleSignal ) ) )
            {
            // InternalArduinoML.g:473:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '<=' ( (lv_value_2_0= ruleSignal ) ) )
            // InternalArduinoML.g:474:3: ( (otherlv_0= RULE_ID ) ) otherlv_1= '<=' ( (lv_value_2_0= ruleSignal ) )
            {
            // InternalArduinoML.g:474:3: ( (otherlv_0= RULE_ID ) )
            // InternalArduinoML.g:475:4: (otherlv_0= RULE_ID )
            {
            // InternalArduinoML.g:475:4: (otherlv_0= RULE_ID )
            // InternalArduinoML.g:476:5: otherlv_0= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getActionRule());
            					}
            				
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_14); 

            					newLeafNode(otherlv_0, grammarAccess.getActionAccess().getActuatorActuatorCrossReference_0_0());
            				

            }


            }

            otherlv_1=(Token)match(input,21,FOLLOW_15); 

            			newLeafNode(otherlv_1, grammarAccess.getActionAccess().getLessThanSignEqualsSignKeyword_1());
            		
            // InternalArduinoML.g:491:3: ( (lv_value_2_0= ruleSignal ) )
            // InternalArduinoML.g:492:4: (lv_value_2_0= ruleSignal )
            {
            // InternalArduinoML.g:492:4: (lv_value_2_0= ruleSignal )
            // InternalArduinoML.g:493:5: lv_value_2_0= ruleSignal
            {

            					newCompositeNode(grammarAccess.getActionAccess().getValueSignalEnumRuleCall_2_0());
            				
            pushFollow(FOLLOW_2);
            lv_value_2_0=ruleSignal();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getActionRule());
            					}
            					set(
            						current,
            						"value",
            						lv_value_2_0,
            						"fr.polytech.si5.dsl.arduino.ArduinoML.Signal");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAction"


    // $ANTLR start "entryRuleTransition"
    // InternalArduinoML.g:514:1: entryRuleTransition returns [EObject current=null] : iv_ruleTransition= ruleTransition EOF ;
    public final EObject entryRuleTransition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTransition = null;


        try {
            // InternalArduinoML.g:514:51: (iv_ruleTransition= ruleTransition EOF )
            // InternalArduinoML.g:515:2: iv_ruleTransition= ruleTransition EOF
            {
             newCompositeNode(grammarAccess.getTransitionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTransition=ruleTransition();

            state._fsp--;

             current =iv_ruleTransition; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTransition"


    // $ANTLR start "ruleTransition"
    // InternalArduinoML.g:521:1: ruleTransition returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= 'is' ( (lv_value_2_0= ruleSignal ) ) otherlv_3= '=>' ( (otherlv_4= RULE_ID ) ) ) ;
    public final EObject ruleTransition() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Enumerator lv_value_2_0 = null;



        	enterRule();

        try {
            // InternalArduinoML.g:527:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= 'is' ( (lv_value_2_0= ruleSignal ) ) otherlv_3= '=>' ( (otherlv_4= RULE_ID ) ) ) )
            // InternalArduinoML.g:528:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= 'is' ( (lv_value_2_0= ruleSignal ) ) otherlv_3= '=>' ( (otherlv_4= RULE_ID ) ) )
            {
            // InternalArduinoML.g:528:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= 'is' ( (lv_value_2_0= ruleSignal ) ) otherlv_3= '=>' ( (otherlv_4= RULE_ID ) ) )
            // InternalArduinoML.g:529:3: ( (otherlv_0= RULE_ID ) ) otherlv_1= 'is' ( (lv_value_2_0= ruleSignal ) ) otherlv_3= '=>' ( (otherlv_4= RULE_ID ) )
            {
            // InternalArduinoML.g:529:3: ( (otherlv_0= RULE_ID ) )
            // InternalArduinoML.g:530:4: (otherlv_0= RULE_ID )
            {
            // InternalArduinoML.g:530:4: (otherlv_0= RULE_ID )
            // InternalArduinoML.g:531:5: otherlv_0= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getTransitionRule());
            					}
            				
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_16); 

            					newLeafNode(otherlv_0, grammarAccess.getTransitionAccess().getSensorSensorCrossReference_0_0());
            				

            }


            }

            otherlv_1=(Token)match(input,22,FOLLOW_15); 

            			newLeafNode(otherlv_1, grammarAccess.getTransitionAccess().getIsKeyword_1());
            		
            // InternalArduinoML.g:546:3: ( (lv_value_2_0= ruleSignal ) )
            // InternalArduinoML.g:547:4: (lv_value_2_0= ruleSignal )
            {
            // InternalArduinoML.g:547:4: (lv_value_2_0= ruleSignal )
            // InternalArduinoML.g:548:5: lv_value_2_0= ruleSignal
            {

            					newCompositeNode(grammarAccess.getTransitionAccess().getValueSignalEnumRuleCall_2_0());
            				
            pushFollow(FOLLOW_17);
            lv_value_2_0=ruleSignal();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getTransitionRule());
            					}
            					set(
            						current,
            						"value",
            						lv_value_2_0,
            						"fr.polytech.si5.dsl.arduino.ArduinoML.Signal");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,23,FOLLOW_3); 

            			newLeafNode(otherlv_3, grammarAccess.getTransitionAccess().getEqualsSignGreaterThanSignKeyword_3());
            		
            // InternalArduinoML.g:569:3: ( (otherlv_4= RULE_ID ) )
            // InternalArduinoML.g:570:4: (otherlv_4= RULE_ID )
            {
            // InternalArduinoML.g:570:4: (otherlv_4= RULE_ID )
            // InternalArduinoML.g:571:5: otherlv_4= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getTransitionRule());
            					}
            				
            otherlv_4=(Token)match(input,RULE_ID,FOLLOW_2); 

            					newLeafNode(otherlv_4, grammarAccess.getTransitionAccess().getNextStateCrossReference_4_0());
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTransition"


    // $ANTLR start "ruleSignal"
    // InternalArduinoML.g:586:1: ruleSignal returns [Enumerator current=null] : ( (enumLiteral_0= 'HIGH' ) | (enumLiteral_1= 'LOW' ) ) ;
    public final Enumerator ruleSignal() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalArduinoML.g:592:2: ( ( (enumLiteral_0= 'HIGH' ) | (enumLiteral_1= 'LOW' ) ) )
            // InternalArduinoML.g:593:2: ( (enumLiteral_0= 'HIGH' ) | (enumLiteral_1= 'LOW' ) )
            {
            // InternalArduinoML.g:593:2: ( (enumLiteral_0= 'HIGH' ) | (enumLiteral_1= 'LOW' ) )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==24) ) {
                alt5=1;
            }
            else if ( (LA5_0==25) ) {
                alt5=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // InternalArduinoML.g:594:3: (enumLiteral_0= 'HIGH' )
                    {
                    // InternalArduinoML.g:594:3: (enumLiteral_0= 'HIGH' )
                    // InternalArduinoML.g:595:4: enumLiteral_0= 'HIGH'
                    {
                    enumLiteral_0=(Token)match(input,24,FOLLOW_2); 

                    				current = grammarAccess.getSignalAccess().getHIGHEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getSignalAccess().getHIGHEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalArduinoML.g:602:3: (enumLiteral_1= 'LOW' )
                    {
                    // InternalArduinoML.g:602:3: (enumLiteral_1= 'LOW' )
                    // InternalArduinoML.g:603:4: enumLiteral_1= 'LOW'
                    {
                    enumLiteral_1=(Token)match(input,25,FOLLOW_2); 

                    				current = grammarAccess.getSignalAccess().getLOWEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getSignalAccess().getLOWEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSignal"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000180000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000190000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000020010L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000003000000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000800000L});

}