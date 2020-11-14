

# Model Checking Differentially Private Properties
This is a model checker checking differentially private properties, which is a plugin of ePMC.
For building, running and other information about ePMC, please visit https://github.com/liyi-david/ePMC.


In this work, the branching time temporal logic dpCTL* is developed for specifying
differential privacy. Several differentially private mechanisms are formalized
as Markov chains or Markov decision processes. Using formal models, subtle
privacy conditions are specified by dpCTL*. In order to verify privacy properties
automatically, model checking problems are investigated. We give and implement a model checking
algorithm for Markov chains and for MDPs, it's shown to be undecidable. 
For more information about our work, please refer to this paper:

Liu D., Wang BY., Zhang L. (2018) Model Checking Differentially Private Properties. In: Ryu S. (eds) Programming Languages and Systems. APLAS 2018. Lecture Notes in Computer Science, vol 11275. Springer, Cham. https://doi.org/10.1007/978-3-030-02768-1_21

Currently our tool has implemented dpCTL model checking algorithm for Markov chains, while for MDPs a sufficient algorithm is introduced.
To perform dpCTL model checking, please set the following options:
```
--property-solver propositional-explicit,operator-explicit,pctl-explicit-next,dpctl-explicit-knowledge,dpctl-explicit-until
--prism-flatten false
--model-input-type mas
--property-input-type dpctl
--smtlib-command-line z3 -smt2 {0} 
--smtlib-version v25 
--constraintsolver-solver smt-lib 
--model-input-files /path/to/your-model
--property-input-files /path/to/your-property
```

In order to use our tool, a model file and a property file is request, following the standards of PRISM format (http://www.prismmodelchecker.org/manual/ThePRISMLanguage).
To specify the differentially private properties, a new operator "<img src="http://latex.codecogs.com/gif.latex?\dpi{110}&space;D\{\epsilon,&space;\delta\}\{Pathformula\}" title="http://latex.codecogs.com/gif.latex?\dpi{110} D\{\epsilon, \delta\}\{Pathformula\}" />" is introduced, 
and it will tell the model checker to check that for any initial states <img src="http://latex.codecogs.com/gif.latex?\dpi{110}&space;s_1" title="http://latex.codecogs.com/gif.latex?\dpi{110} s_1" /> and <img src="http://latex.codecogs.com/gif.latex?\dpi{110}&space;s_2" title="http://latex.codecogs.com/gif.latex?\dpi{110} s_2" />(assumed in neighborhood relations), 
whether <img src="http://latex.codecogs.com/gif.latex?\dpi{110}&space;Pr(s_1\models&space;Pathformula)&space;\le&space;e^{\epsilon}&space;Pr(s_2\models&space;Pathformula)&space;&plus;&space;\delta" title="http://latex.codecogs.com/gif.latex?\dpi{110} Pr(s_1\models Pathformula) \le e^{\epsilon} Pr(s_2\models Pathformula) + \delta" /> holds. 
If there's a violation of the formula,
differential privacy is not achieved and a counterexample of  <img src="http://latex.codecogs.com/gif.latex?\dpi{110}&space;s_1" title="http://latex.codecogs.com/gif.latex?\dpi{110} s_1" /> and <img src="http://latex.codecogs.com/gif.latex?\dpi{110}&space;s_2" title="http://latex.codecogs.com/gif.latex?\dpi{110} s_2" />, along with the probabilities will be given. Otherwise, the model checker returns an answer "yes". Examples of formulae are shown below:

```
D {3, 0} [F (1 < s & s <= 2) ] 
D {1, 0} [X ((d = -1) & (t = -1) )]
```
There are several models and properties:
```
yn.prism/yn.pctl  ---  a simple survey mechanism, dtmc
yn2.prism/yn2.pctl   ---  a suvey mechanism with high/low precision, mdp
Abovethreshold.prism/Abovethreshold.pctl --- the Abovethreshold algorithm, dtmc
color.prism/color.pctl  ---  a color sampling algorithm, dtmc
```
