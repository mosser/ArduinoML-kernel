<?xml version="1.0" encoding="UTF-8"?>
<model ref="r:56d5ba8d-780f-4924-9a87-49e56f7184ec(ArduinoML.sandbox)">
  <persistence version="9" />
  <languages>
    <use id="33bc471f-7ff1-4164-888c-dae68d0d60e1" name="ArduinoML" version="-1" />
  </languages>
  <imports />
  <registry>
    <language id="33bc471f-7ff1-4164-888c-dae68d0d60e1" name="ArduinoML">
      <concept id="3136056854312017207" name="ArduinoML.structure.App" flags="ng" index="37dXSw">
        <child id="3136056854312017210" name="bricks" index="37dXSH" />
      </concept>
      <concept id="3136056854312017265" name="ArduinoML.structure.Actuator" flags="ng" index="37dXTA" />
      <concept id="3136056854312017264" name="ArduinoML.structure.Sensor" flags="ng" index="37dXTB" />
      <concept id="3136056854312017147" name="ArduinoML.structure.Brick" flags="ng" index="37dXZG">
        <property id="3136056854312017212" name="pin" index="37dXSF" />
      </concept>
    </language>
    <language id="ceab5195-25ea-4f22-9b92-103b95ca8c0c" name="jetbrains.mps.lang.core">
      <concept id="1169194658468" name="jetbrains.mps.lang.core.structure.INamedConcept" flags="ng" index="TrEIO">
        <property id="1169194664001" name="name" index="TrG5h" />
      </concept>
    </language>
  </registry>
  <node concept="37dXSw" id="2I5wLvGGKuJ">
    <property role="TrG5h" value="redButton" />
    <node concept="37dXTA" id="2I5wLvGGKuO" role="37dXSH">
      <property role="TrG5h" value="led" />
      <property role="37dXSF" value="9" />
    </node>
    <node concept="37dXTB" id="2I5wLvGGKuY" role="37dXSH">
      <property role="TrG5h" value="button" />
      <property role="37dXSF" value="12" />
    </node>
  </node>
</model>

