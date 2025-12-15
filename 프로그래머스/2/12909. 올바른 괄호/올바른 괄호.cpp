#include<string>
#include <iostream>
#include <bits/stdc++.h>
// #include <queue>

using namespace std;

bool solution(string s)
{
    bool answer = true;
    int i = 0;
    for(char x : s){
        if (x == '(')
            i++;
        else if (x == ')' && i == 0){
            answer = false;
        } else
            i--;
    }
    if(i != 0)
        answer = false;

    return answer;
}