#!/bin/sh
if [ $# -eq 0 ]; then    echo "usage: $0 <c-source-file>" >&2
    exit -1
fi

input=$(cat <<EOF
William 35 25000
Kishore 41 35000
Wallace 37 30000
Bruce 39 29999
EOF)

output=$(cat <<EOF
William 35 28000
Kishore 41 35000
Wallace 37 30000
Bruce 39 32999
EOF)

echo "$input" > work.txt
echo "$input" > .expect.stdout.txt
echo "$output" >> .expect.stdout.txt
echo "$output" > .expect.work.txt
(gcc "$1" -o main && ./main | diff .expect.stdout.txt - && diff .expect.work.txt work.txt) && echo PASS || echo FAIL
rm -f main work.txt .expect.work.txt .expect.stdout.txt