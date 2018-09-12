#include <iostream>
#include <string>
#include <vector>
#include <queue>


using namespace std;





class Graph{

public:
	vector <int> * adj ;
	int V;

	int* indegree;

	Graph(int V){
		adj = new vector <int> [V];
		this->V =  V;
		indegree =  new int [V];

		for(int i =0; i <V; i++){
			indegree[i] = 0;
		}



	}


	void setNeigbours(){
		cout << "Enter neigbours of the vertices , vertices should start from 0" << endl;
		bool flag ;
		int temp;
		for(int i =0; i < V; i++){
			cout << "Enter " << i << "'th vertex neighbours "<< endl;
			flag =  true;
			while(flag){
				cin >> temp;
				if (temp == -1){
					flag = false;
				}
				else{

					indegree[temp] = indegree[temp]+1;
					adj[i].push_back(temp);
				}


			}

		}
	}


	void topologicalSort(){
		queue <int> q1;

		for (int i=0; i < V; i++){
			if (indegree[i] == 0){
				q1.push(i);
			}
		}

		while(!q1.empty()){
			int j = q1.front();
			cout << j << "  " << endl;
			q1.pop();

			for (int i =0; i < adj[j].size(); i++){
				int k  =  adj[j].at(i);
				indegree [k] -= 1;
				if (indegree[k] == 0){
					q1.push(k);
				}
			}


		}

	}





};


int main() {
		cout << "Enter no of vertices in the graph " << endl;

		int V;
		cin  >> V;

		Graph g(V);
		g.setNeigbours();
		cout << "--------------------------"<< endl;
		g.topologicalSort();



		return 0;

	}










