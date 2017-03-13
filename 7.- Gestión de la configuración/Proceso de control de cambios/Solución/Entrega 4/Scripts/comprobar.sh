#!/bin/bash

cd "SC$1"

numDir=`ls -1 | wc -l`
cd "Commit 1 - Entrada de solicitud"

if [[ $numDir -ne  4 && $numDir -ne 7 ]]; then
	echo "Faltan commits"
	exit
fi

if [[ ! -e "SC$1_1.1.pdf" ]]; then
	exit
fi
echo "Commit 1: OK"

cd ..
cd "Commit 2 - Redirección del analista"

if [[ ! -e "SC$1_1.2.pdf" ]]; then
	exit
fi
echo "Commit 2: OK"

cd ..
cd "Commit 3 - Estudio del equipo"

if [[ ! -e "SC$1_1.3.pdf" || ! -e "SC$1_2.1.pdf" ]]; then
	exit
fi
echo "Commit 3: OK"

cd ..
cd "Commit 4 - Decisión del director"

if [[ ! -e "SC$1_1.4.pdf" || ! -e "SC$1_2.2.pdf" ]]; then
	exit
fi
echo "Commit 4: OK"

if [[ $numDir -eq 7 ]]; then
	cd ..
	cd "Commit 5 - Ejecución"

	if [[ ! -e "SC$1_2.3.pdf" ]]; then
		exit
	fi
	echo "Commit 5: OK"

	cd ..
	cd "Commit 6 - Pruebas"

	numPruebas=`ls -1 SC$1_3.?.1.pdf | wc -l`
	if [[ ! -e "SC$1_2.4.pdf" || $numPruebas -eq 0 ]]; then
		exit
	fi
	echo "Commit 6: OK. Encontradas $numPruebas pruebas"

	cd ..
	cd "Commit 7 - Ejecutado"

	numPruebas2=`ls -1 SC$1_3.?.2.pdf | wc -l`
	if [[ ! -e "SC$1_1.5.pdf" || ! -e "SC$1_2.5.pdf" || $numPruebas -ne $numPruebas2 ]]; then
		exit
	fi
	echo "Commit 7: OK. Encontradas $numPruebas2 pruebas"
fi