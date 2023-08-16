


const graph = {
    a: ['c','b'],
    b: ['d'],
    c: ['e'],
    d:['f'],
    e:[],
    f:[]
};

const DFS_Print = (graph, source) =>{

    const stack = [source];

    while(stack.length > 0){
        const current= stack.pop();
        console.log(current);

        for (let neighbor of graph[current]){
            stack.push(neighbor);
        }
    }

};

DFS_Print(graph,'a');