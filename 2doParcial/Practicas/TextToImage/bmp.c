
#include "bmp.h"

unsigned char * readBMP(char * filename, bmpInfoHeader * bInfoHeader, FILE * file, char * newFile) {

    FILE * f;
    bmpFileHeader header; /* cabecera */
    unsigned char * imgdata; /* datos de imagen */
    uint16_t type; /* 2 bytes identificativos */

    unsigned char fillHeader[84];

    f = fopen(filename, "r");
    file = fopen(newFile, "w+");
    if (!f)
        return NULL; 

    
    fread( & type, sizeof(uint16_t), 1, f);
    fwrite( & type, sizeof(uint16_t), 1, file);
    if (type != 0x4D42)  {
        fclose(f);
        return NULL;
    }

    
    fread( & header, sizeof(bmpFileHeader), 1, f);
    fwrite( & header, sizeof(bmpFileHeader), 1, file);

    
    fread(bInfoHeader, sizeof(bmpInfoHeader), 1, f);
    fwrite(bInfoHeader, sizeof(bmpInfoHeader), 1, file);

   
    imgdata = (unsigned char * ) malloc(bInfoHeader -> imgsize);

    fread(fillHeader, 84, 1, f);
    fwrite(fillHeader, 84, 1, file);

    fread(imgdata, bInfoHeader -> imgsize, 1, f);

    
    fclose(f);
    fclose(file);

    
    return imgdata;
}

int readText(char * fileName, char * msg) {

    FILE * file;
    file = fopen(fileName, "r");
    char caracter;
    int cont = 0;

    char msj[2] = "";

    while (1) {

        fscanf(file, "%c", & caracter);
        msj[0] = caracter;
        msj[1] = 0;
        strcat(msg, msj);
        cont++;

        if (feof(file))
            break;
    }

    msg[cont - 1] = 0;

    return cont - 1;
}

void doCipher(unsigned char * img, char * msg, int tamImg, int tamMsg) {

    unsigned char auxBit = 1;
    unsigned char saveByte;

    unsigned char auxSaveBit;
    unsigned char auxImgBit;

    int j = 0;
    for (int i = 0; i < tamMsg; ++i) {
        for (int numBit = 0, auxBit = 128; numBit < 8; numBit++, j++) {

            auxSaveBit = msg[i] & auxBit;
            auxImgBit = img[i * 8 + numBit] & 1;

            if (auxSaveBit == 0) {

                img[j] = img[j] & 254;

            } else {

                img[j] = img[j] | 255;
            }

            auxBit = auxBit / 2;

        }
    }

}

void doDescipher(unsigned char * img, char * msgName, int tamImg, int tamMsg) {

    unsigned char caracter;
    unsigned char palabra = 0;
    unsigned char cont = 1;
    int j = 0;
    FILE * nuevImg;

    nuevImg = fopen(msgName, "w+");

    for (int i = 0; i < tamMsg * 8;) {

        caracter = 0;

        for (j = 0, cont = 128; j < 8; j++, i++) {
            caracter = caracter | ((img[i] & 1) * cont);
            cont = cont / 2;
        }

        fwrite( & caracter, 1, 1, nuevImg);

    }
    fclose(nuevImg);
}