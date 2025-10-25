#include <string>
#include <vector>
#include <algorithm>
#include <cctype>

using namespace std;

struct File{
    string original;
    string head;
    int number;
    int idx;
};

File parse(const string& filename, int& idx){
    File file;
    file.original = filename;
    file.idx = idx;
    
    int i = 0;
    while(i < filename.length() && !isdigit(filename[i])){
        file.head += tolower(filename[i]);
        i++;
    }
    
    string n;
    while(i < filename.length() && isdigit(filename[i]) && n.size() < 5){
        n += filename[i];
        i++;
    }
    file.number = stoi(n);
    return file;
}

vector<string> solution(vector<string> files) {
    vector<string> answer;
    
    vector<File> parsedFile;
    
    for(int i = 0; i < files.size(); i++){
        parsedFile.push_back(parse(files[i], i));
    }
    
    sort(parsedFile.begin(), parsedFile.end(), [](const File& a, const File& b) {
        if(a.head != b.head){
            return a.head < b.head;
        }
        if(a.number != b.number){
            return a.number < b.number;
        }
        return a.idx < b.idx;
    });
    
    for(const auto& a: parsedFile){
        answer.push_back(a.original);
    }
    
    return answer;
}