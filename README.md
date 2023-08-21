# compiladores_2023.2

Este projeto tem como objetivo implementar um compilador para uma nova linguagem de programação, a fefo language.
Este compilador irá obter um código em linguagem fefo e transformá-lo em um código equivalente em java.
Para este projeto, utilizo a ferramenta antlr (https://www.antlr.org).

Instruções: Para utilizar, basta baixar o projeto e abrir com seu IDE de preferencia. Rode a função main dentro do pacote fefolanguage.main, e não a MainClass.java externa, que é apenas o output do compilador.

Para compilar seu código, altere o arquivo input.fefo, e rode a main class, escolhendo qual a linguagem de saída.

Se quiser alterar a gramática, basta instalar o antlr (já incluso no projeto), instanciar o build path para que a função mais consiga acessar os pacotes utilizados, alterar o arquivo FefoLang.g4 para a gramática que quiser, e rodar o comando descrito em comandosAntlr.txt em um prompt de comando. Isso vai alterar o parser, lexer e tudo que é necessário para compilar.
