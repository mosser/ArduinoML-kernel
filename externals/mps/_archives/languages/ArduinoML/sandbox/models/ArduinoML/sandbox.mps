<?xml version="1.0" encoding="UTF-8"?>
<model ref="r:ee7059f0-5334-4193-b87b-3b710f3975bb(ArduinoML.sandbox)">
  <persistence version="9" />
  <languages>
    <use id="5edee0cf-46e1-49f9-971e-6b9e2e5cae16" name="ArduinoML" version="-1" />
    <use id="ceab5195-25ea-4f22-9b92-103b95ca8c0c" name="jetbrains.mps.lang.core" version="-1" />
  </languages>
  <imports />
  <registry>
    <language id="5edee0cf-46e1-49f9-971e-6b9e2e5cae16" name="ArduinoML">
      <concept id="6483884641801180718" name="ArduinoML.structure.State" flags="ng" index="3uOfik">
        <child id="6483884641801182880" name="transition" index="3uOfKq" />
        <child id="6483884641801182858" name="actions" index="3uOfKK" />
      </concept>
      <concept id="6483884641801181722" name="ArduinoML.structure.Action" flags="ng" index="3uOfyw">
        <property id="6483884641801182714" name="status" index="3uOfX0" />
        <reference id="6483884641801182716" name="actuator" index="3uOfX6" />
      </concept>
      <concept id="6483884641801182720" name="ArduinoML.structure.Transition" flags="ng" index="3uOfMU">
        <property id="6483884641801182748" name="status" index="3uOfMA" />
        <reference id="6483884641801182750" name="sensor" index="3uOfM$" />
        <reference id="6483884641801253235" name="target" index="3uPXf9" />
      </concept>
      <concept id="8218746718699842484" name="ArduinoML.structure.Sensor" flags="ng" index="3T334G" />
      <concept id="8218746718699866923" name="ArduinoML.structure.Actuator" flags="ng" index="3T3p6N" />
      <concept id="8218746718699866924" name="ArduinoML.structure.Brick" flags="ng" index="3T3p6O">
        <property id="8218746718699890346" name="pin" index="3T3nKM" />
      </concept>
      <concept id="8218746718699866925" name="ArduinoML.structure.App" flags="ng" index="3T3p6P">
        <reference id="6483884641801182886" name="init_state" index="3uOfKs" />
        <child id="6483884641801182883" name="states" index="3uOfKp" />
        <child id="8218746718699890354" name="bricks" index="3T3nKE" />
      </concept>
    </language>
    <language id="ceab5195-25ea-4f22-9b92-103b95ca8c0c" name="jetbrains.mps.lang.core">
      <concept id="1133920641626" name="jetbrains.mps.lang.core.structure.BaseConcept" flags="ng" index="2VYdi">
        <property id="1193676396447" name="virtualPackage" index="3GE5qa" />
      </concept>
      <concept id="1169194658468" name="jetbrains.mps.lang.core.structure.INamedConcept" flags="ng" index="TrEIO">
        <property id="1169194664001" name="name" index="TrG5h" />
      </concept>
    </language>
  </registry>
  <node concept="3T3p6P" id="78eQDyb1OBR">
    <property role="TrG5h" value="RedButton" />
    <ref role="3uOfKs" node="5BVoFE7b3gR" resolve="off" />
    <node concept="3T3p6N" id="78eQDyb1OBV" role="3T3nKE">
      <property role="TrG5h" value="red_led" />
      <property role="3T3nKM" value="12" />
      <property role="3GE5qa" value="3" />
    </node>
    <node concept="3T334G" id="78eQDyb1OC1" role="3T3nKE">
      <property role="TrG5h" value="button" />
      <property role="3T3nKM" value="9" />
    </node>
    <node concept="3uOfik" id="5BVoFE7b3gR" role="3uOfKp">
      <property role="TrG5h" value="off" />
      <node concept="3uOfyw" id="5BVoFE7b3gT" role="3uOfKK">
        <property role="3uOfX0" value="false" />
        <ref role="3uOfX6" node="78eQDyb1OBV" resolve="red_led" />
      </node>
      <node concept="3uOfMU" id="5BVoFE7bb5L" role="3uOfKq">
        <property role="3uOfMA" value="true" />
        <ref role="3uOfM$" node="78eQDyb1OC1" resolve="button" />
        <ref role="3uPXf9" node="5BVoFE7bd4v" resolve="on" />
      </node>
    </node>
    <node concept="3uOfik" id="5BVoFE7bd4v" role="3uOfKp">
      <property role="TrG5h" value="on" />
      <node concept="3uOfyw" id="5BVoFE7bd4$" role="3uOfKK">
        <property role="3uOfX0" value="true" />
        <ref role="3uOfX6" node="78eQDyb1OBV" resolve="red_led" />
      </node>
      <node concept="3uOfMU" id="5BVoFE7bd4E" role="3uOfKq">
        <property role="3uOfMA" value="true" />
        <ref role="3uOfM$" node="78eQDyb1OC1" resolve="button" />
        <ref role="3uPXf9" node="5BVoFE7b3gR" resolve="off" />
      </node>
    </node>
  </node>
  <node concept="3T3p6P" id="12ryeWwq$5d">
    <property role="TrG5h" value="AnnoyingBuzzer" />
    <ref role="3uOfKs" node="12ryeWwq$5h" resolve="silent" />
    <node concept="3T3p6N" id="12ryeWwq$5e" role="3T3nKE">
      <property role="TrG5h" value="red_led" />
      <property role="3T3nKM" value="12" />
      <property role="3GE5qa" value="3" />
    </node>
    <node concept="3T3p6N" id="12ryeWwq$5f" role="3T3nKE">
      <property role="TrG5h" value="annoying_buzzer" />
      <property role="3GE5qa" value="6" />
      <property role="3T3nKM" value="11" />
    </node>
    <node concept="3T334G" id="12ryeWwq$5g" role="3T3nKE">
      <property role="TrG5h" value="button" />
      <property role="3T3nKM" value="9" />
    </node>
    <node concept="3uOfik" id="12ryeWwq$5h" role="3uOfKp">
      <property role="TrG5h" value="silent" />
      <node concept="3uOfyw" id="12ryeWwq$5i" role="3uOfKK">
        <property role="3uOfX0" value="false" />
        <ref role="3uOfX6" node="12ryeWwq$5e" resolve="red_led" />
      </node>
      <node concept="3uOfyw" id="12ryeWwq$5j" role="3uOfKK">
        <property role="3uOfX0" value="false" />
        <ref role="3uOfX6" node="12ryeWwq$5f" resolve="annoying_buzzer" />
      </node>
      <node concept="3uOfMU" id="12ryeWwq$5k" role="3uOfKq">
        <property role="3uOfMA" value="true" />
        <ref role="3uOfM$" node="12ryeWwq$5g" resolve="button" />
        <ref role="3uPXf9" node="12ryeWwq$5l" resolve="buzzing" />
      </node>
    </node>
    <node concept="3uOfik" id="12ryeWwq$5l" role="3uOfKp">
      <property role="TrG5h" value="buzzing" />
      <node concept="3uOfyw" id="12ryeWwq$5m" role="3uOfKK">
        <property role="3uOfX0" value="true" />
        <ref role="3uOfX6" node="12ryeWwq$5e" resolve="red_led" />
      </node>
      <node concept="3uOfyw" id="12ryeWwq$5n" role="3uOfKK">
        <property role="3uOfX0" value="true" />
        <ref role="3uOfX6" node="12ryeWwq$5f" resolve="annoying_buzzer" />
      </node>
      <node concept="3uOfMU" id="12ryeWwq$5o" role="3uOfKq">
        <property role="3uOfMA" value="true" />
        <ref role="3uOfM$" node="12ryeWwq$5g" resolve="button" />
        <ref role="3uPXf9" node="12ryeWwq$5h" resolve="silent" />
      </node>
    </node>
  </node>
</model>

