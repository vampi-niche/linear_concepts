const graph = {
    a: ['c','b'],
    b: ['d'],
    c: ['e'],
    d:['f'],
    e:[],
    f:[]
};

const BFS_print = (graph,source) => {

    const queue = [source];

    while(queue.length > 0){
        const current = queue.shift();

        console.log(current)

        for(let neighbor of graph[current])
        {
            queue.push(neighbor)
        }

    }

}

BFS_print(graph,'a');