
#include "bmp.h"


int main(int arg, char * argv[]) {
    bmpInfoHeader info;
    unsigned char * img;
    char msg[1000] = "";
    int tamMsg = 0;

    if (atoi(argv[3]) == 1) {
        char newFileName[100] = "out";
        strcat(newFileName, argv[1]);

        FILE * nuevImg;

        img = readBMP(argv[1], & info, nuevImg, newFileName);
        tamMsg = readText(argv[2], msg);

        if (img == NULL) {
            printf("Formato invalido\n");
            return 0;
        }

        doCipher(img, msg, info.imgsize, tamMsg);

        nuevImg = fopen(newFileName, "a");
        fwrite(img, info.imgsize, 1, nuevImg);
        fclose(nuevImg);
    } else if (atoi(argv[3]) == 2) {
        char newFileName[100] = "out2-";
        strcat(newFileName, argv[1]);

        FILE * nuevImg;

        img = readBMP(argv[1], & info, nuevImg, newFileName);

        if (img == NULL) {
            printf("Formato invalido\n");
            return 0;
        }
        doDescipher(img, argv[2], info.imgsize, atoi(argv[4]));
    } else {
        printf("Error en parametros\n");
        return 0;
    }

    return 0;
}