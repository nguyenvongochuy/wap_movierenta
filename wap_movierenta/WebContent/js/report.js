"use strict";
let chart = Highcharts.chart('container', {
    chart: {
        type: 'column',
        borderRadius: 10,
        marginBottom: 100
    },
    title: {
    	style: {
    		fontWeight: 'bold'
    	},
        text: 'Top 10 movies on demand.'
    },
    xAxis: {
        type: 'category',
        labels: {
        	autoRotationLimit: 100,
            style: {
                fontSize: '13px',
                fontFamily: 'Verdana, sans-serif'
            }
        }
    },
    yAxis: {
        min: 0,
        title: {
            text: 'Number of demands'
        }
    },
    legend: {
        enabled: true
    },
    tooltip: {
        pointFormat: 'Demands: <b>{point.y:.1f} times</b>'
    },
    series: [{
        name: 'Number of demands',
        data: [
            
        ],
        dataLabels: {
            enabled: true,
            rotation: 0,
            color: '#FFFFFF',
            align: 'center',
            format: '{point.y:.1f}', // one decimal
            y: 10, // 10 pixels down from the top
            style: {
                fontSize: '13px',
                fontFamily: 'Verdana, sans-serif'
            }
        }
    }]
});

(function($) {
    const app = {
        init: function() {
        	this.radioData = $('input[type=radio][name="radioData"]');
        	this.radioType = $('input[type=radio][name="radioType"]');
            this.bindEvents();
            this.loadData();
        },
        loadData: function() {
        	let dataType = $("input[name='radioData']:checked").val();
        	$.ajax({
                url: "reportData?datatype="+dataType,
                dataType: 'json',
                success: (data) => {
                    let reports = [];
                    let xAxis = data.xAxis;
                    let yAxis = data.yAxis;
                    let index = 0;
                    for (let x of xAxis) {
                    	let arr = [x, yAxis[index]];
                    	reports.push(arr);
                    	index++;
                    }
                    console.log("ajax: " + reports);
                    chart.series[0].setData(reports);

                    if(dataType == "demand"){
                    	chart.setTitle({text: 'Top 10 movies on demand'});
                    	chart.yAxis[0].axisTitle.attr({
                            text: 'Number of demands'
                        });
                        $(chart.legend.allItems[0].legendItem.element.childNodes).text('Number of demands');
                    }else{
                    	chart.setTitle({text: 'Top 10 rating movies'});
                        chart.yAxis[0].axisTitle.attr({
                            text: 'Rating'
                        });
                        $(chart.legend.allItems[0].legendItem.element.childNodes).text('Rating');
                    }
                    
                },
                error: (error) => {
                    console.log("ajax: " + error);
                }
            });
        },
        bindEvents: function() {
        	this.radioData.bind('change', this.loadData.bind(this));
        	this.radioType.bind('change', this.changeType.bind(this));
        },
        changeType(){
        	this.changeTypeOfSeries($("input[name='radioType']:checked").val());
        },
        changeTypeOfSeries: function(typ) {
        	let dataType = $("input[name='radioData']:checked").val();
        	let name = dataType == "demand" ? 'Number of demands' : 'Rating';
            chart.series.forEach((el, inx) => {
              el.update({
            	  name: name,
            	  type: typ
              });
            });
        }
    }
    app.init();
})(jQuery, chart);

