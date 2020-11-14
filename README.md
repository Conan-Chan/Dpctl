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


In order to use our tool, the models and properties should follow the PRISM format (http://www.prismmodelchecker.org/manual/ThePRISMLanguage).
To specify the differentially private properties, a new operator "$$D\{\epsilon, \delta\}\{Pathformula\}$$" is introduced, 
and it will tell the model checker to check that for any initial states $$s_1$$ and $$s_2$$(assumed in neighborhood relations), 
whether $$Pr(s_1\models Pathformula) \le e^{\epsilon} Pr(s_2\models Pathformula) + \delta$$ holds. If there's a violation of the formula,
the differentially private properties

```

```
