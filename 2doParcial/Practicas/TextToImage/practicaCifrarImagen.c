	#include <stdio.h>
	#include <stdlib.h>
	#include <stdint.h>
	#include <string.h>

	typedef struct bmpFileHeader
	{
	  /* 2 bytes de identificación */
	  uint32_t size;        /* Tamaño del archivo */
	  uint16_t resv1;       /* Reservado */
	  uint16_t resv2;       /* Reservado */
	  uint32_t offset;      /* Offset hasta hasta los datos de imagen */
	} bmpFileHeader;

	typedef struct bmpInfoHeader
	{
	  uint32_t headersize;      /* Tamaño de la cabecera */
	  uint32_t width;       /* Ancho */
	  uint32_t height;      /* Alto */
	  uint16_t planes;          /* Planos de color (Siempre 1) */
	  uint16_t bpp;             /* bits por pixel */
	  uint32_t compress;        /* compresión */
	  uint32_t imgsize;     /* tamaño de los datos de imagen */
	  uint32_t bpmx;        /* Resolución X en bits por metro */
	  uint32_t bpmy;        /* Resolución Y en bits por metro */
	  uint32_t colors;      /* colors used en la paleta */
	  uint32_t imxtcolors;      /* Colores importantes. 0 si son todos */
	} bmpInfoHeader;

	unsigned char *LoadBMP(char *filename, bmpInfoHeader *bInfoHeader,FILE *file,char * newFile);
	int loadMSG(char *fileName,char *msg);
	void DisplayInfo(bmpInfoHeader *info);
	void TextDisplay(bmpInfoHeader *info, unsigned char *img);
	void DisplayInfo(bmpInfoHeader *info);
	void Cifra(unsigned char *img,char *msg,int tamImg,int tamMsg);
	void Descifra(unsigned char *img,char *msgName,int tamImg,int tamMsg);

	int main(int arg,char *argv[])
	{
	  bmpInfoHeader info;
	  unsigned char *img;
	 char msg[1000]="";
	 int tamMsg;
	 

	 if(strcmp(argv[3],"Cipher")!=1){

	    char nameNewFile[100]="cipher-";
	    strcat(nameNewFile,argv[1]);


	    FILE *nuevImg;

	    img=LoadBMP(argv[1], &info,nuevImg,nameNewFile);
	    tamMsg=loadMSG(argv[2],msg);

	    printf("Msg:%s \n tam: %d\n",msg,tamMsg);

	      if(img==NULL){

	        printf("No es una imagen bmp\n");

	        return 0;
	      }


	    DisplayInfo(&info);
	    Cifra(img,msg,info.imgsize,tamMsg);
	    //TextDisplay(&info, img);

	    nuevImg=fopen(nameNewFile,"a");
	    fwrite(img, info.imgsize,1, nuevImg);
	    fclose(nuevImg);
	  }
	  else{

	    char nameNewFile[100]="Descipher-";
	    strcat(nameNewFile,argv[1]);


	    FILE *nuevImg;

	    img=LoadBMP(argv[1], &info,nuevImg,nameNewFile);
	    //tamMsg=loadMSG(argv[2],msg);

	    //printf("Msg:%s \n tam: %d\n",msg,tamMsg);

	      if(img==NULL){

	        printf("No es una imagen bmp\n");

	        return 0;
	      }


	    DisplayInfo(&info);
	    Descifra(img,argv[2],info.imgsize,atoi(argv[4]));



	  }


	  return 0;
	}

	void TextDisplay(bmpInfoHeader *info, unsigned char *img)
	{
	  int x, y;
	  /* Reducimos la resolución vertical y horizontal para que la imagen entre en pantalla */
	  static const int reduccionX=6, reduccionY=4;
	  /* Si la componente supera el umbral, el color se marcará como 1. */
	  static const int umbral=90;
	  /* Asignamos caracteres a los colores en pantalla */
	  static unsigned char colores[9]=" bgfrRGB";
	  int r,g,b;
	  unsigned int cont=0;
	  /* Dibujamos la imagen */

	  /*
	  for (y=info->height; y>0; y-=reduccionY)
	    {
	      for (x=0; x<info->width; x+=reduccionX)
	    {

	      printf("%d,",img[3*(x+y*info->width)]);
	      printf("%d,",img[3*(x+y*info->width)+1]);
	      printf("%d",img[3*(x+y*info->width)+2]);
	      printf("-");
	     


	     
	      cont++;
	    }
	      printf("\n");
	    }*/


	  for (int i = 0; i < info->imgsize; ++i)
	  {
	    printf("%d ",img[i]);
	  }

	    printf("cont: %d\n",cont );


	}

	unsigned char *LoadBMP(char *filename, bmpInfoHeader *bInfoHeader,FILE *file,char * newFile)
	{

	  FILE *f;
	  bmpFileHeader header;     /* cabecera */
	  unsigned char *imgdata;   /* datos de imagen */
	  uint16_t type;        /* 2 bytes identificativos */


	  unsigned char fillHeader[84];

	  f=fopen (filename, "r");
	  file=fopen(newFile,"w+");
	  if (!f)
	    return NULL;        /* Si no podemos leer, no hay imagen*/

	  /* Leemos los dos primeros bytes */
	  fread(&type, sizeof(uint16_t), 1, f);
	  fwrite(&type, sizeof(uint16_t), 1, file);
	  if (type !=0x4D42)        /* Comprobamos el formato */
	    {
	      fclose(f);
	      return NULL;
	    }

	  /* Leemos la cabecera de fichero completa */
	  fread(&header, sizeof(bmpFileHeader), 1, f);
	  fwrite(&header, sizeof(bmpFileHeader), 1, file);

	  /* Leemos la cabecera de información completa */
	  fread(bInfoHeader, sizeof(bmpInfoHeader), 1, f);
	  fwrite(bInfoHeader, sizeof(bmpInfoHeader), 1, file);

	  /* Reservamos memoria para la imagen, ¿cuánta? 
	     Tanto como indique imgsize */
	  imgdata=(unsigned char*)malloc(bInfoHeader->imgsize);


	  fread(fillHeader, 84,1, f);
	  fwrite(fillHeader, 84,1, file);


	  /* Nos situamos en el sitio donde empiezan los datos de imagen,
	   nos lo indica el offset de la cabecera de fichero*/
	  //fseek(f, header.offset, SEEK_SET);


	  /* Leemos los datos de imagen, tantos bytes como imgsize */
	  fread(imgdata, bInfoHeader->imgsize,1, f);
	  
	  


	  /* Cerramos */
	  fclose(f);
	  fclose(file);

	  /* Devolvemos la imagen */
	  return imgdata;
	}


	int loadMSG(char *fileName, char *msg){

	  FILE *file;
	  file=fopen(fileName,"r");
	  char caracter;
	  int cont=0;

	  char msj[2]="";

	  

	  while(1==1){

	    fscanf(file,"%c",&caracter);
	    msj[0]=caracter;
	    msj[1]=0;
	    strcat(msg,msj);
	    cont++;

	    if(feof(file))
	      break;

	   // printf("%c", caracter);

	  }

	  msg[cont-1]=0;

	 // printf("\n");

	  return cont-1;


	}

	void Cifra(unsigned char *img,char *msg,int tamImg,int tamMsg){

	  printf("\nMensaje:\n ");
	  

	  unsigned char auxBit=1;
	  unsigned char saveByte;  

	  unsigned char auxSaveBit;
	  unsigned char auxImgBit;

	  int j=0;
	  for (int i = 0; i < tamMsg; ++i)
	  {
	    
	     printf("%c: ",msg[i]);
	    for(int numBit=0,auxBit=128;numBit<8;numBit++,j++){

	      auxSaveBit=msg[i]&auxBit;
	      auxImgBit=img[i*8+numBit]&1;

	     // printf("auxS: %x, auxI %x\n ",auxSaveBit,auxImgBit);

	      printf(" %x ",img[j] );

	      if( auxSaveBit==0 ){

	        img[j]=img[j]&254;
	      // printf(" img: %x\n ",img[j]);

	      }
	      else{

	         img[j]=img[j]|255;
	      }
	   // printf("Modificado:%x \n",img[i*numBit*8+numBit] );
	      auxBit=auxBit/2;

	//       printf("%x ",img[i*8+numBit]);

	    }
	     printf("\n");
	  }

	  printf("\n");


	}


	void Descifra(unsigned char *img,char *msgName,int tamImg,int tamMsg){


	unsigned char caracter;
	unsigned char palabra=0;
	unsigned char cont=1;
	int j=0;
	FILE *nuevImg;

	nuevImg=fopen(msgName,"w+");

	  for (int i = 0; i < tamMsg*8; )
	  {

	    caracter=0;

	    for(j=0,cont=128;j<8;j++,i++){
	      caracter=caracter|((img[i]&1)*cont);
	      cont=cont/2;
	    }

	    printf("%c ",caracter );
	    fwrite(&caracter,1,1,nuevImg );


	    //printf("%x ",caracter);

	     
	  }

	  printf("\n");


	    
	    fclose(nuevImg);




	}

	void DisplayInfo(bmpInfoHeader *info)
	{
	  printf("Tamaño de la cabecera: %u\n", info->headersize);
	  printf("Anchura: %d\n", info->width);
	  printf("Altura: %d\n", info->height);
	  printf("Planos (1): %d\n", info->planes);
	  printf("Bits por pixel: %d\n", info->bpp);
	  printf("Compresión: %d\n", info->compress);
	  printf("Tamaño de datos de imagen: %u\n", info->imgsize);
	  printf("Resolucón horizontal: %u\n", info->bpmx);
	  printf("Resolucón vertical: %u\n", info->bpmy);
	  printf("Colores en paleta: %d\n", info->colors);
	  printf("Colores importantes: %d\n", info->imxtcolors);
	}