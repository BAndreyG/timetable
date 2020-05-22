var messageApiHistiry=Vue.resource('/history/{id}');
var messageApiClient=Vue.resource('/client/{id}');
var messageApiMain=Vue.resource('/history/test');

Vue.component('td-row',{
    props:['cli'],
   template: '<tbody>' +
       '<template v-for="n in 16">'+
       '<tr v-if="cli.time==18">' +
       '<td>{{ n+7 }}:00 </td>'+
       '<td id="monday" :value="cli.clientName">{{cli.clientName}}</td>' +
       '<td id="tuesday">{{cli.day}}</td>' +
       '<td id="wednesday">if</td>' +
       '<td id="thursday"></td>' +
       '<td id="friday"></td>' +
       '<td id="saturday"></td>' +
       '<td id="sunday"></td>' +
       '</tr>' +
       '<tr v-else>' +
       '<td>{{ n+7 }}:00 </td>'+
       '<td id="monday" :value="cli.clientName"></td>' +
       '<td id="tuesday">{{cli.day}}</td>' +
       '<td id="wednesday">else</td>' +
       '<td id="thursday"></td>' +
       '<td id="friday"></td>' +
       '<td id="saturday"></td>' +
       '<td id="sunday"></td>' +
       '</tr>' +
       '</template>'+
       '</tbody>'
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
        '<td-row v-for="cli in clientWeek"  :key="cli.id"  :cli="cli" />'+
        '</table>',
    data:{clientWeek:[]},
    created:function(){
        messageApiMain.get().then(result=>
            result.json().then(
                data=>data.forEach(cli=>this.clientWeek.push(cli))
            )
        )
    }
});