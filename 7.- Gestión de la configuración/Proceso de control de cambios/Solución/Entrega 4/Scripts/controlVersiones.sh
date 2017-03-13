#!/bin/bash

# Tres argumentos: identificador del cambio, directorio de trabajo y directorio
# del repositorio. Se debe ejecutar en el directorio que contenga las carpetas SCXXX

if [[ $# -ne 3 ]]; then
	echo "Uso: $0 ID workDir repoDir"
	echo "Ejemplo: $0 001 '../Proyecto' 'file:///C:/../repositorio'"
	exit
fi

idCambio=$1
workDir=$2
repoDir=$3

# Función que hace los commits
# Argumento 1: Nombre de la subcarpeta del commit correspondiente
# Argumento 2: Mensaje del commit
function hacerCommit {
	dirCommit="SC$idCambio/$1"
	mensaje=$2
	
	# Se copia lo correspondiente al commit en el directorio de trabajo. Con una expresión
	# regular se le quita el .x (versión) del final, no se necesita (para algo usamos svn coño)
	ls -1 "$dirCommit" | sed -r "s/(.*)..\.pdf/cp '${dirCommit//\//\\/}\/\0' '${workDir//\//\\/}\/\1.pdf'/" | bash

	# Antes de de poder hacer un commit, hay que 'añadir' los archivos al directorio de trabajo
	# En realidad solo hace falta para la primera versión de cada archivo, pero si se hace de más,
	# tan solo saca un warning, y nos ahorramos comprobaciones
	svn add $workDir/* 2> /dev/null # Para que no molesten los warnings

	# Se procede a hacer el commit, con su mensajito
	svn commit -m "$mensaje" "$workDir"
}


# Se crea una nueva rama, en base al tronco, con nombre SCXXX y un mensajito
svn copy -r1 "$repoDir/Proyecto/trunk" "$repoDir/Proyecto/branches/SC$idCambio" -m "Creación de rama para tratar la petición SC$idCambio"

# Como se va a trabajar en la rama, se hace 'switch' a la rama en el directorio de trabajo
svn switch "$repoDir/Proyecto/branches/SC$idCambio" "$workDir"

# Se llama a la función que hace todo el salseo, para el primer commit
hacerCommit "Commit 1 - Entrada de solicitud" "Entrada de la solicitud"
echo "Commit 1: OK"

if [[ `ls -1 "SC$idCambio" | wc -l` -ge 2 ]]; then
	hacerCommit "Commit 2 - Redirección del analista" "Redirección del analista"
	echo "Commit 2: OK"

	hacerCommit "Commit 3 - Estudio del equipo" "Estudio del equipo"
	echo "Commit 3: OK"
fi

if [[ `ls -1 "SC$idCambio" | wc -l` -ge 4 ]]; then
	hacerCommit "Commit 4 - Decisión del director" "Decisión del director"
	echo "Commit 4: OK"
fi

# Si el directorio de los documentos contiene 7 subdirectorios, hay que hacer más commits
if [[ `ls -1 "SC$idCambio" | wc -l` -eq 7 ]]; then
	hacerCommit "Commit 5 - Ejecución" "Ejecución"
	echo "Commit 5: OK"

	hacerCommit "Commit 6 - Pruebas" "Pruebas"
	echo "Commit 6: OK"

	hacerCommit "Commit 7 - Ejecutado" "Ejecutado"
	echo "Commit 7: OK"
fi

# La rama ya está hecha, se vuelve al tronco antes de hacer el merge
svn switch "$repoDir/Proyecto/trunk" "$workDir"

# Se hace el merge de la rama contra el tronco
svn merge "$repoDir/Proyecto/branches/SC$idCambio" "$workDir"
echo "Merge: OK"

# Se eliminan los archivos procendentes de la rama que no queremos que estén en el tronco
svn delete $workDir/SC${idCambio}_2.pdf
svn delete $workDir/SC${idCambio}_3*.pdf 2> /dev/null # A lo mejor este no existe

# Se hace el commit definitivo
svn commit -m "Procesamiento completado para SC$idCambio" "$workDir"