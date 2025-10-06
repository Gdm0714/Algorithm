#include <string>
#include <vector>
#include <map>
#include <sstream>
#include <cmath>

using namespace std;

int changeMinute(string time){
    int hour = stoi(time.substr(0, 2));
    int minute = stoi(time.substr(3, 2));
    return hour * 60 + minute;
}

int calculate(int sumTime, vector<int>& fees){
    int defaultTime = fees[0];
    int defaultFee = fees[1];
    int unitTime = fees[2];
    int unitFee = fees[3];
    
    if(sumTime <= defaultTime){
        return defaultFee;
    }
    
    int remainTime = sumTime - defaultTime;
    int remainFee = (int)ceil((double)remainTime / unitTime) * unitFee;
    
    return defaultFee + remainFee;
}

vector<int> solution(vector<int> fees, vector<string> records) {
    vector<int> answer;
    
    map<string, int> inTime;
    map<string, int> sumTime;
    
    for(string record: records){
        stringstream ss(record);
        string time, car, status;
        
        ss >> time >> car >> status;
        
        int minute = changeMinute(time);
        
        if(status == "IN"){
            inTime[car] = minute;
        }else{
            int parkingTime = minute - inTime[car];
            sumTime[car] += parkingTime;
            inTime.erase(car);
        }
    }
    
    int exitTime = 23 * 60 + 59;
    for(auto& m: inTime){
        string car = m.first;
        int time = m.second;
        sumTime[car] += exitTime - time;
    }
    
    for(auto& m: sumTime){
        int fee = calculate(m.second, fees);
        answer.push_back(fee);
    }
    return answer;
}