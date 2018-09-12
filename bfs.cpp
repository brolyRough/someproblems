#include <iostream>
#include <string>
#include <queue>
#include <vector>

using namespace std;

class Graph {
public:
	int V;
	vector<int> * adj;

	int *level ;
	int *parent;

	Graph(int V) {
		this->V = V;
		adj = new vector<int> [V];
		level = new int [V];
		parent = new int [V];
	}

	void setNeighbors() {
		bool flag;
		int a;
		for (int i = 0; i < V; i++) {
			cout << "Enter " << i
					<< "'th neighbors one by one and enter -1 to end " << endl;
			flag = true;
			while (flag) {
				cin >> a;
				if (a == -1)
					flag = false;
				else {
					adj[i].push_back(a);
				}
			}

		}
	}

	void getNeighbors() {
		cout << "printing neighbors " << endl;
		for (int i = 0; i < V; i++) {
			cout << i << "'th neighbors are ";
			for (int j = 0; j < adj[i].size(); j++) {
				cout << adj[i].at(j) << " ";
			}
			cout << endl;
		}
	}

	void BFS(int s) {

		for (int i = 0; i < V; i++) {
			level[i] = -1;
			parent[i] = -1;
		}

		queue<int> q;
		q.push(s);
		level[s] = 0;
		int temp;
		while (!q.empty()) {
			temp = q.front();

			q.pop();
			for (int i = 0; i < adj[temp].size(); i++) {
				if (level[adj[temp].at(i)] == -1) {
					q.push(adj[temp].at(i));
					parent[adj[temp].at(i)] = temp;
					level[adj[temp].at(i)] = 1 + level[temp];
				}
			}
		}


	}

	void BFSRoute(int s, int d){

		if(s==d){
			cout << "destination : " << s << " <- " << d << " : source "<< endl;
			return ;
		}

		int i = d;
		cout << "destination : " << d << " <- ";
		while(parent[i] != -1){
			cout << parent[i] << " <- " ;
			i = parent[i];
		}
		cout << " : source " << endl;

	}

	void totatBFS(int s) {
		cout << "Breadth first search from the source vertex  "<< s << " to all the other vertices " << endl;

		BFS(s);

		for(int i=0; i<V; i++){
			cout << "Route from " << s << " to " << i << endl;
			BFSRoute(s,i);
		}

		cout << "\n\n Teja Bharatha is the best programmer in the world " << endl;
	}

	void allLevels(int s){
		cout << "levels of other vertices from the source vertex " << s << " are " << endl;
		BFS(s);
		for(int i=0; i <V;i++){
			cout << "for " << i << " is " << level[i] << endl;
		}
	}

};



int main(){
	cout << "Enter no of vertices " << endl;
	int V;
	cin >> V;
	cout << "vertices should be  numbered from 0 to " << V-1 << endl;
	Graph g(V);
	g.setNeighbors();
	g.totatBFS(0);

	g.allLevels(0);

	return 0;

}







