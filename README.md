# PixelCanvas

## Como Usar

1. Clona o repositório, compila e roda o programa, ele vai abrir essa tela:
![alt text](http://i.imgur.com/hUee5MY.png "lol")

2. Essa telinha que abre mostra as coordenadas do mouse na tela, agora tem que editar arquivo Settings.java

2.1 Nas coordenadas do Point color0_pos, coloque as coordenadas do seu mouse na primeira cor da barra:
![alt text](http://i.imgur.com/XjZiEH2.png "lol")

2.2 Nas coordenadas dos Points "start" e "end", coloque as coordenadas do seu mouse nos cantos superiores do desenho,
no nosso caso os cantos são os pixels (-2160,80) e (-2083,80) do pixelcanvas:
![alt text](http://i.imgur.com/CeQyDv8.png "lol")

OBS.: Tenta centralizar o cursor no quadradinho e depois que medir a posição não scrolla a tela!
OBS2.: Funciona com qualquer zoom, mas a imagem tem 92 pixels de altura e se não tiverem 92 pixels de espaço
com o zoom que tiver usando o programa vai tentar desenhar fora da tela.

2.3 Os firstPointX, firstPointY, finalPointX, finalPointY são as coordenadas da seção retangular que vc quer
desenhar da imagem. Pra desenhar a imagem inteira seria firstPoint(0,0) e finalPoint(78,92) pois a imagem tem 78x92 pixels.
Cuidado pra não desenhar em um pedaço que alguem ja tiver desenhando, se não é perda de tempo.

2.4 Finalmente tem que setar o cooldown. Nesse lugar que tamo desenhando o cooldown é 145 segundos, aí a variável cooldown
fica em 145000 (porque é em milisegundos).

3. Compila e roda o programa, e com a pagina do pixelcanvas aberta no fundo naquela posição 
específica que vc deixou, clica em start. GG




