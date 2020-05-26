var messageApiHistiry=Vue.resource('/history/{id}');
var messageApiClient=Vue.resource('/client/{id}');
var messageApiMain=Vue.resource('/history/test');

Vue.component('td-row',{
    props:['clientWeek'],
    // template:'<div>{{clientWeek}}</div>'
   template: '<tbody>' +
       '<template v-for="n in 16">'+
    '<template v-for="cli in clientWeek"  >' +
       // '<template v-for="cli in clientWeek" />'+
       '<tr v-if="cli.time==n+7">' +
       '<td>{{ n+7 }}:00 </td>'+
       '<td v-if="cli.day==1" class="monday">{{cli.clientName}}</td>' +
       '<td v-else class="monday"></td>' +
       '<td v-if="cli.day==2" class="tuesday">{{cli.clientName}}</td>' +
       '<td v-else class="tuesday"></td>' +
       '<td v-if="cli.day==3" class="wednesday">{{cli.clientName}}</td>' +
       '<td v-else class="cli.day"></td>' +
       '<td v-if="cli.day==4" class="thursday">{{cli.clientName}}</td>' +
       '<td v-else class="cli.day"></td>' +
       '<td v-if="cli.day==5" class="5">{{cli.clientName}}</td>' +
       '<td v-else class="friday">{{cli.day}}</td>' +
       '<td v-if="cli.day==6" class="saturday">{{cli.clientName}}</td>' +
       '<td v-else class="saturday"></td>' +
       '<td v-if="cli.day==7" class="sunday">{{cli.clientName}}</td>' +
       '<td v-else class="sunday"></td>' +
       '</tr>' +
       '<tr v-else>' +
       '<td>{{ n+7 }}:00 </td>'+
       '<td class="monday" :value="cli.clientName"></td>' +
       '<td class="tuesday"></td>' +
       '<td class="wednesday">else</td>' +
       '<td class="thursday"></td>' +
       '<td class="friday"></td>' +
       '<td class="saturday"></td>' +
       '<td class="sunday"></td>' +
       '</tr>' +
       '</template>'+
       '</template>'+
       '</tbody>',
    methods: {
        checkDay:function(a,b){
            if (a==b)console.log(a,b);
            // console.log(this);
            return true;
        }
    }
});

var app = new Vue({
    el: '#tableBody',
    template:'<table border="3" align="centre" class="table-striped" >'+
        '<thead>'+
        '<tr>'+
            '<th>ЧЧ:ММ</th>'+
            '<th>Понедельник</th>'+
            '<th>Вторник</th>'+
            '<th>Среда</th>'+
            '<th>Четверг</th>'+
            '<th>Пятница</th>'+
            '<th>Суббота</th>'+
            '<th>Воскресенье</th>'+
        '</tr>'+
        '</thead>'+
        '<td-row :clientWeek="clientWeek" />'+
// '<td-row v-for="n in 16" :key="n" :n="n" />'+
        '</table>',
    data:{clientWeek:[]},
    created:function(){
        messageApiMain.get().then(result=>
            result.json().then(
                data=>data.forEach(c=>this.clientWeek.push(c))
            )
        )
    }
});