#include <stdio.h> 
#include <stdlib.h> 
#include <stdint.h> 
#include <string.h>

typedef struct bmpFileHeader {
	        /* 2 bytes de identificación */
	        uint32_t size; /* Tamaño del archivo */
	        uint16_t resv1; /* Reservado */
	        uint16_t resv2; /* Reservado */
	        uint32_t offset; /* Offset hasta hasta los datos de imagen */
} bmpFileHeader;

typedef struct bmpInfoHeader {
    uint32_t headersize; /* Tamaño de la cabecera */
    uint32_t width; /* Ancho */
    uint32_t height; /* Alto */
    uint16_t planes; /* Planos de color (Siempre 1) */
    uint16_t bpp; /* bits por pixel */
    uint32_t compress; /* compresión */
    uint32_t imgsize; /* tamaño de los datos de imagen */
    uint32_t bpmx; /* Resolución X en bits por metro */
    uint32_t bpmy; /* Resolución Y en bits por metro */
    uint32_t colors; /* colors used en la paleta */
    uint32_t imxtcolors; /* Colores importantes. 0 si son todos */
} bmpInfoHeader;

unsigned char * readBMP(char * filename, bmpInfoHeader * bInfoHeader, FILE * file, char * newFile);
int readText(char * fileName, char * msg);
void doCipher(unsigned char * img, char * msg, int tamImg, int tamMsg);
void doDescipher(unsigned char * img, char * msgName, int tamImg, int tamMsg);